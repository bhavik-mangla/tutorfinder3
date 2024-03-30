const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.database();

// Endpoint to store a new tutor
exports.addTutor = functions.https.onRequest(async (req, res) => {
    try {
        const tutorData = req.body;
        const newTutorRef = await db.ref('tutors').push();
        await newTutorRef.set(tutorData);
        return res.status(201).json({ message: 'Tutor added successfully' });
    } catch (error) {
        return res.status(500).json({ error: error.message });
    }
});

// Endpoint to get all tutors
exports.getAllTutors = functions.https.onRequest(async (req, res) => {
    try {
        const snapshot = await db.ref('tutors').once('value');
        const tutors = snapshot.val();
        return res.status(200).json(tutors);
    } catch (error) {
        return res.status(500).json({ error: error.message });
    }
});
