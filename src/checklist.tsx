// AssessmentQuestionsScreen.js
import React, { useState } from 'react';
import { View, Text, ScrollView, TouchableOpacity, StyleSheet } from 'react-native';
import { useNavigation } from '@react-navigation/native';

const questions = [
  'Hitting, Slapping, Punching',
  'Pushing, Shoving, or Restraining',
  'Denying access to basic needs like food, water, or sleep',
  'Throwing objects or damaging property',
  'Forced or unwanted sexual acts',
  'Constructive criticism, insults, or put-downs',
  'Controlling behavior and monitoring activities',
  'Isolating the victim from family and friends',
  'Gaslighting or manipulating reality',
  'Intimidation or threats',
  'Yelling, screaming, or using a harsh tone consistently',
  'Name-calling or using derogatory language',
  'Threatening with violence',
  'Monitoring or controlling the victim\'s online activities',
  'Harassing or threatening through social media',
  'Using technology to control or manipulate the victim',
];

const AssessmentQuestionsScreen = () => {
  const [selectedQuestions, setSelectedQuestions] = useState([]);
  const navigation = useNavigation();

  const toggleQuestion = (index) => {
    const newSelectedQuestions = [...selectedQuestions];
    newSelectedQuestions[index] = !newSelectedQuestions[index];
    setSelectedQuestions(newSelectedQuestions);
  };

  const handleSubmit = () => {
    navigation.navigate('AssessmentResult');
  };

  return (
    <View style={styles.container}>
      <ScrollView contentContainerStyle={styles.scrollContent}>
        {questions.map((question, index) => (
          <TouchableOpacity
            key={index}
            style={[
              styles.question,
              selectedQuestions[index] && styles.selectedQuestion,
            ]}
            onPress={() => toggleQuestion(index)}
          >
            <Text style={styles.questionText}>{question}</Text>
            {selectedQuestions[index] && <Text>✓</Text>}
          </TouchableOpacity>
        ))}
      </ScrollView>
      <TouchableOpacity style={styles.submitButton} onPress={handleSubmit}>
        <Text style={styles.submitButtonText}>Submit</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
  },
  scrollContent: {
    padding: 16,
  },
  question: {
    backgroundColor: '#4EA8FC',
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: 10,
    marginBottom: 8,
    borderRadius: 8,
  },
  selectedQuestion: {
    backgroundColor: '#4EA8FC',
  },
  questionText: {
    color: 'white',
    flex: 1,
  },
  submitButton: {
    backgroundColor: '#4EA8FC',
    paddingVertical: 16,
    alignItems: 'center',
  },
  submitButtonText: {
    color: 'white',
    fontSize: 18,
  },
});

export default AssessmentQuestionsScreen;
