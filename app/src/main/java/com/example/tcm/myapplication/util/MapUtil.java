package com.example.tcm.myapplication.util;

import com.example.tcm.myapplication.entity.Data2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/9/12 12:35
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/9/12 12:35
 * @see
 */
public class MapUtil {

    public static Map getMap(){
        HashMap<Object, List<Data2>> map = new HashMap<>();
        map.put("Shuguang Hospital",getData1());
        map.put("Yueyang Hospital",getData2());
        map.put("Longhua Hospital",getData3());
        map.put("Shanghai Traditional Chinese Medicine(TCM) Hospital",getData4());
        map.put("Shanghai TCM-Integrated Hospital",getData5());
        return map;
    }

    private static List<Data2> getData1(){
        ArrayList<Data2> list1 = new ArrayList<>();
        Data2 data1 = new Data2();
        data1.setKey("Department of Anal Disease");
        data1.setValue("The anal disease department of Shuguang Hospital has a long history, which was first established in 1956 by Chen Zechao, a famous specialist in treating hemorrhoid in Shanghai. In 1990, the Shuguang Hospital in Shanghai was the first to set up the anal disease department of traditional Chinese Medicine. The annual number of outpatients is over 8000 and more than 5000 operations are carried out in a year.");
        Data2 data2 = new Data2();
        data2.setKey("Department of Orthopedics and Traumatology");
        data2.setValue("The orthopedics and traumatology department is established on the basis of \"The school of Shi's Traumatology\" which has a history of more than 130 years, and has been listed as a national intangible cultural heritage in 2008. Professor Shi Yinyu and Professor Zhan Hongsheng, excellent experts at orthopedics and traumatology of traditional Chinese medicine, carried out a systematic study on the prevention and treatment of chronic and joint diseases in China.");
        Data2 data3 = new Data2();
        data3.setKey("Department of Nephrology");
        data3.setValue("The nephrology department was founded in the 1950s. It integrates clinical treatment with teaching and scientific research and has 60 years of clinical experience. It has formed advantages and characteristics in the treatment of early and middle stage renal failure, IgA nephropathy, chronic tubulointerstitial lesions and diabetic nephropathy.");
        Data2 data4 = new Data2();
        data4.setKey("Department of Gynecology");
        data4.setValue("The gynecology department pays the greatest attention to treating gynecologic tumor and infertility by the integration of Chinese and Western medicine. It also provides counselling service of infertility, pre-pregnancy preparation and family planning.   Treatments for gynecological diseases are according to seasons. Gynecological diseases caused by cold womb are treated by placing medicated patch of medicinal herbs on acupuncture points in hot summer days. Deficiency patterns in women are treated according to the theory that disease mostly occurring in winter should be treated in winter.");
        Data2 data5 = new Data2();
        data5.setKey("Department of Traditional Chinese Medicine");
        data5.setValue("At the beginning of 2005, Shuguang Hospital took the lead in setting up a clinical department--traditional Chinese medicine department, which pieces together various traditional Chinese medicine therapies, and set up independent out-patient department  and wards to give full play to the characteristics and advantages of comprehensive treatment of traditional Chinese medicine.");
        Data2 data6 = new Data2();
        data6.setKey("Department of Tuina");
        data6.setValue("The Tuina department is one of the traditional departments of Shuguang Hospital. Famous Tuina doctors, such as Cheng Bingqing, Zhou Huilin once worked here. and The department is featured by Shanghai style medical massage techniques. Other traditional Chinese therapies are also used with tuina like Daoying, acupuncture, and cupping to treat spinal, internal and infantile diseases. This department enjoys a high reputation in Shanghai.");
        Data2 data7 = new Data2();
        data7.setKey("Department of Acupuncture and Moxibustion");
        data7.setValue("This department is committed to the clinical diagnosis and treatment of various pain, stroke, facial paralysis, tinnitus and deafness, cerebral palsy, menstrual disorders, uterine fibroids and other diseases. It has developed a variety of effective techniques for the treatment of cervical spondylosis.");
        list1.add(data1);
        list1.add(data2);
        list1.add(data3);
        list1.add(data4);
        list1.add(data5);
        list1.add(data6);
        list1.add(data7);
        return list1;
    }

    private static List<Data2> getData2(){
        ArrayList<Data2> list2 = new ArrayList<>();
        Data2 data1 = new Data2();
        data1.setKey("Department of Acupuncture and Moxibustion");
        data1.setValue("This department offers treatment for various diseases: apoplexy, urethral syndrome, chronic colitis, Parkinson's disease, peripheral facial paralysis, scapulohumeral periarthritis, insomnia, rheumatism, rheumatoid diseases, obesity, gynecological diseases. It especially excels at the following 9 diseases: apoplexy, facial paralysis, arthropathy (frozen shoulder and gonarthritis), insomnia, perimenopause syndrome, Parkinson’s disease, ulcerative colitis, irritable bowel syndrome, and urethral syndrome. Characteristic techniques include:\n" +
                "⑴\tAdopting “staging, typing and balancing between yin-yang and multi-points with one needle” to treat sequelae of apoplexy.\n" +
                "⑵\t“Combining points along the meridians and at the three facial lines” to treat facial paralysis (peripheral facial paralysis).\n" +
                "⑶\t“Needling points along the meridians and triple directional needling at the local ashi points” to treat frozen shoulder (scapulohumeral periarthritis).\n" +
                "⑷\t“Moxibustion at multi-points” to treat knee osteoarthritis.\n" +
                "⑸\t“Moxibustion on herbs” to treat ulcerative colitis.\n" +
                "⑹\tSpecial techniques to treat irritable bowel syndrome.\n" +
                "⑺\tCombining moxibustion with acupuncture to treat Crohn’s disease.\n" +
                "⑻\tSpecial techniques to treat dry eyes.");
        Data2 data2 = new Data2();
        data2.setKey("Department of Tuina");
        data2.setValue("This department was founded in 1976 which is called the cradle of modern Tuina in China. During 60 years’ development, it has created countless “first” in the community of Tuina. It has always stressed combination of Tuina and modern medicine and has put forward innovative theories such as “tender manipulations smoothing the tendons and powerful ones strengthening” and “giving priority to the tendons when there is disharmony between tendons and bones”.");
        Data2 data3 = new Data2();
        data3.setKey("Department of Gynecology");
        data3.setValue("It is the first independent gynecology department of traditional Chinese medicine(TCM) in Shanghai with a number of excellent TCM doctors including Pro. Zhu Nansun and Pro. Shen Zhongli both awarded with the title of TCM Master. With “inheriting from the outstanding senior TCM doctors and combining TCM with western medicine” as its features and “highlighting TCM features, letting TCM play its unique roles and combining TCM to improve the comprehensive strengths” as its tenets, this department has achieved great effects in the treatment of menstrual irregularities, infertility, menstrual pain, endometriosis, pelvic inflammatory diseases, dysfunctional uterine bleeding, uterine myoma, ovarian cysts, menopausal syndrome, etc.");
        Data2 data4 = new Data2();
        data4.setKey("Department of Dermatology");
        data4.setValue("This department has treated psoriasis by “determining treatment from blood”, gout by “clearing heat, removing dampness and freeing the vessels”, eczema by “cooling blood, subduing hyperactivity of liver yang and tranquilizing”, and pimples and acne by “combining herbs, needles and facial masks” . In the past 3 years, the number of patients has increased, and the work of medical services, teaching and research has been coordinated and developed. The level of diagnosis and treatment has both ranked high in China.");
        Data2 data5 = new Data2();
        data5.setKey("Department of Internal Medicine");
        data5.setValue("This department has 7 TCM clinics for specific diseases: chronic fatigue syndrome, arrhythmia, insomnia, headache, fatty liver, prevention, sweating pattern and has all produced good effects. Guided by the principle of “holistic conception and prevention first before onset of diseases”, this department is centered on the harmonization of five zang-organ and six fu-organ. They have comprehensively applied herbs and other physical therapies such as plaster therapy, acupuncture, moxibustion, ear points, infrared therapy, hilum therapy, rehabilitation exercises, etc to miscellaneous internal diseases, and have produced good effects.");
        Data2 data6 = new Data2();
        data6.setKey("Department of Endocrinology");
        data6.setValue("This department has been continuously summing up experience in long-term clinical work, giving full play to the therapeutic advantages of integrated traditional Chinese and western medicine, especially in the diagnosis and treatment of diabetes, metabolic syndrome, the immunological intervention of Hashimoto thyroiditis and the control of the high risk factors of thyroid nodules. Significant clinical efficacy has been achieved.\n" +
                "For patients with diabetes and metabolic syndrome, this department adds TCM therapies based on western medicine’s control of blood pressure and other risk factors. At present, this department has basically completed the establishment of the patient database, which will actively lay the foundation for the research and development of new TCM drugs.");
        Data2 data7 = new Data2();
        data7.setKey("Department of Rheumatology");
        data7.setValue("As the key specialty center, members of Rheumatology Department all have a master’s or above degree, and they have long been committed to the improvement of the efficacy and the reduction of the side effects of the drug. The characteristics of this department are mainly reflected in three aspects: “integrated medicine and individualization for the treatment of rheumatism; TCM for treating Sjogren’s syndrome; TCM for reducing the side effects of hormones”. This department has developed and implemented a relatively complete diagnosis and treatment routine for common rheumatism. ");
        list2.add(data1);
        list2.add(data2);
        list2.add(data3);
        list2.add(data4);
        list2.add(data5);
        list2.add(data6);
        list2.add(data7);
        return list2;
    }

    private static List<Data2> getData3(){
        ArrayList<Data2> list3= new ArrayList<>();
        Data2 data1 = new Data2();
        data1.setKey("Department of Acupucture and Moxibustion");
        data1.setValue("Over the years, this department has always advocated and persisted in the Chinese medicine tradition, inherits and passes down the traditional acupuncture and moxibustion skills and specialties from the older generation of famous acupuncturists, including acupuncture, moxibustion, warming needle moxibustion, cupping, and three-edged needles therapy. Nowadays, modern therapies are also used, such as electric-acupuncture, acupoint injection, and auricular acupuncture, scalp acupuncture, herbal paste on acupoints, catgut embedment in acupoints to treat common and complicated diseases in different departments. Effects are satisfactory, particularly in stroke, facial paralysis, neuralgia, joint pain, insomnia, acute and chronic diarrhea, simple obesity, andrological and gynecological diseases.");
        Data2 data2 = new Data2();
        data2.setKey("Department of Tuina");
        data2.setValue("Since its establishment in 1960, this department has always been adhering to the hospital motto in medical services. After several generations’ efforts, it has developed special comprehensive treatment plans with manual therapy as a primary method combined with traction, cupping, acupoint paste, low-frequency electric therapy, oral and external Chinese and Western medication. The department has achieved significant therapeutic effects on cervical spondylosis, lumbar disc herniation, frozen shoulder, acute and chronic soft tissue injury, degenerative Osteoarthritis, chronic fatigue syndrome, dysmenorrhea, pediatric muscular torticollis, pediatric diarrhea and other diseases.");
        Data2 data3 = new Data2();
        data3.setKey("Department of Internal Medicine of Traditional Chinese Medicine");
        data3.setValue("This department consists of several subsections including Divisions of Lung diseases, of spleen and stomach diseases, of hematopathy, of heart diseases, of nephrology, rheumatism etc. Each division has distinguished experts in different areas.");
        Data2 data4 = new Data2();
        data4.setKey("Department of Gynecology");
        data4.setValue("This department accumulates abundant experience in integrated Chinese and Western medicine treatment of gynecological endocrine disorders, endometriosis, infertility, chronic pelvic inflammatory disease, ovarian tumors, uterine fibroids, recurrent miscarriage, menopausal syndrome and other common diseases. Our specialties of dysmenorrhea and menorrhagia are listed as superior projects by the State Administration of Traditional Chinese Medicine. Infertility, chronic pelvic inflammation and abdominal mass (ovarian chocolate cysts) are listed as superior projects of Honghua Hospital.");
        Data2 data5 = new Data2();
        data5.setKey("Department of Oncology");
        data5.setValue("This department provides therapies specialized in integrative treatment of traditional Chinese medicine and Western medicine and adopts a standardized, interdisciplinary and comprehensive treatment module. It has applied an integration of chemotherapy and Chinese medicine therapy for tumors, staging treatment with traditional Chinese medicine for lung cancer, a compound of holistic treatment and partial treatment, as well as a combination of traditional treatment and molecular targeting therapy, which all significantly prolong patients’ lifetime and also improve their life quality.");
        list3.add(data1);
        list3.add(data2);
        list3.add(data3);
        list3.add(data4);
        list3.add(data5);
        return list3;
    }

    private static List<Data2> getData4(){
        ArrayList<Data2> list4= new ArrayList<>();
        Data2 data1 = new Data2();
        data1.setKey("Department of Pediatrics");
        data1.setValue("Established in 1950s, this department was led by Professor Yu Jianer, the vice president of the pediatrics branch of China Association of Chinese Medicine, the famous pediatric specialist and the doctoral supervisor, over more than 50 years with tremendous efforts and the academic status of Chinese medicine has been continuously improved. It is in the leading position in the field of pediatrics and in China.");
        Data2 data2 = new Data2();
        data2.setKey("Department of Encephalopathy");
        data2.setValue("For the common diseases and frequently-occurring diseases of encephalopathy, such as cerebral infarction, cerebral hemorrhage, stroke sequelae, etc., this department gives full play to the advantages of integrated Chinese and Western medicine. Traditional Chinese and Western medicines are combined with acupuncture, Tuina and other physiotherapy methods to provide comprehensive treatment. For some neurological problems, such as motor neuron disease, trigeminal neuralgia, hereditary cerebellar ataxia, etc., this department makes effectively use Chinese medicinal herbs through syndrome pattern diagnosis and treatment differentiation to delay the development of the disease.");
        Data2 data3 = new Data2();
        data3.setKey("Department of Oncology");
        data3.setValue("In the treatment of tumor, the oncology department puts various methods together as a whole to provide comprehensive treatment plans. It mainly uses Chinese medicinal herbs to treat tumors combined with other treatment including chemotherapy, intervention, biological targeting and immune therapy. At the same time, it also actively carries out many special therapies, such as acupoint application, ear acupuncture and fumigation. It has created a series of effective formulas to fight against tumor, remove edema, reduce the side effects of chemotherapy, which plays an important role in prolonging the survival of patients and improving the life quality of patients.");
        Data2 data4 = new Data2();
        data4.setKey("Department of Tuina");
        data4.setValue("Based on clinical practice, the diagnosis and treatment in Tuina department has given full play to the characteristics of traditional Chinese medicine and accumulated a great deal of clinical experience. Over the years, the department has been a medical service provider for the Olympic Games, the national games and the world championships, and has fulfilled the task excellently.");
        Data2 data5 = new Data2();
        data5.setKey("Department of Acupuncture and Moxibustion");
        data5.setValue("In recent years, under the leadership of director Xu Shifen, the department of acupuncture and moxibustion follows the principle of combining inheritance and innovation, maintaining and developing the characteristics and advantages of acupuncture and moxibustion, which has made great progress in many aspects such as medicine, education, scientific research and so on. This department is rich in scientific research, and has undertaken many national, provincial and ministerial level projects including the NSFC(Natural Science Foundation of China), and its staff has published nearly 100 scientific research papers. It is good at treating mental diseases, acupuncture and moxibustion, stroke, facial paralysis, aspiration, dysuria and knee joint disease.");
        list4.add(data1);
        list4.add(data2);
        list4.add(data3);
        list4.add(data4);
        list4.add(data5);
        return list4;
    }

    private static List<Data2> getData5(){
        ArrayList<Data2> list5= new ArrayList<>();
        Data2 data1 = new Data2();
        data1.setKey("Department of Vascular Disease");
        data1.setValue("This department was established in 1970 by professor Xi jiuyi, a great expert at integrated traditional and Western medicine. After over 40 years of hard work, it has developed the academic thoughts and clinical experience that stasis caused by evils should be differentiated in different stages. Tens of preparations for internal or external use have been created. The scope of diagnosis and treatment of vascular diseases has been expanded to cover 38 kinds of vascular diseases classified into five categories including arteries, veins, skin blood vessels, lymphatic vessels, vascular autonomic nerves.");
        Data2 data2 = new Data2();
        data2.setKey("Department of Dermatology");
        data2.setValue("For decades, this department has fully utilized the combination of traditional Chinese medicine and Western medicine to treat common skin diseases and venereal disease (VD), and it is good at skin surgery. It has accumulated a lot of valuable experience and enjoys a good social reputation. It develops 6 characteristic self-made Chinese medicinal preparations that has unique curative effects, namely Shan Ling Kang Yin Granules, Si Shen Kang Yin Granules, Fu Fang Wu Mei Granules, Zi Dan Liang Xue Granules, Fu Fang Gui Qi Granules and Qing Zi Granules.");
        Data2 data3 = new Data2();
        data3.setKey("Department of Acupuncture, Tuina and Rehabilitation");
        data3.setValue("With a combination of modern concepts, the department follows ancient ways to perform acupuncture, moxibustion, sandwiched moxibustion, cupping, Tuina, bonesetting, physiotherapy, occupational therapy, speech therapy and other therapies. \n" +
                "It is good at treating fatigue, obesity, menstrual disorders, polycystic ovary syndrome, hyperlipidemia, hyperviscosity, stroke sequelae facial paralysis, headache, tinnitus, deafness, gastric abscess, hiccups, cervical spondylosis, lumbar spondylosis, scapulohumeral periarthritis and other bone and joint locomotor system diseases and various pains.");
        Data2 data4 = new Data2();
        data4.setKey("Department of Traditional Chinese Medicine");
        data4.setValue("The offers treatment service to a wide range of diseases, including internal medicine, surgery, dermatology, gynecology and other diseases. When it comes to specific treatment, the department adopts a comprehensive principle and combines together acupuncture and moxibustion, fumigation, local application therapy, cupping, food therapy, emotional therapy, rehabilitation, guidance and other treatment methods apart from simple application of decoction and injection. It follows the principle that when traditional Chinese medicine alone can work, no western medicine method is used and makes sure that traditional Chinese medicine plays the primary role if western medicine is applied.");
        list5.add(data1);
        list5.add(data2);
        list5.add(data3);
        list5.add(data4);
        return list5;
    }

    public static Map getHeaders(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("Shuguang Hospital","● Location and transportation\n" +
                "Shuguang Hospital (Eastern)\n" +
                "Address: No. 528, Zhang Heng Road, Pudong New District, Shanghai\n" +
                "Route: Metro Line 2, Zhangjiang High-tech station, exit 5, → Zhang Nan special line/Bus 1057 / Bus188 → Zhang Heng Road Keyuan Road, \n" +
                "Shuguang Hospital (Western)\n" +
                "Address: No. 185, Puan Road, Huangpu District, Shanghai.\n" +
                "Route: Metro Line 1, Huangpi South Road station\n" +
                "Bus: No. 02、17、18、23、109、126、42、46、112、123、217、220、401、575、537、781、782、789、802、831、864、911、920、925、926、932、980\n" +
                "\n" +
                "● Departments");
        map.put("Yueyang Hospital","Metro: Line 2, 12 or 13 at West Nanjing Road\n" +
                "Bus: No. 20, 23, 24, 37, 41, 49, 109, 112\n" +
                "\n" +
                "● Departments");
        map.put("Longhua Hospital","● Location and transportation\n" +
                "Address: 725 Wanping South Road, Xuhui District, Shanghai\n" +
                "Metro: Line 4 and 7\n" +
                "Bus: 41, 44, 49, 50, 72, 89, 104, 111, 218,733,864\n" +
                "\n" +
                "● Departments");
        map.put("Shanghai Traditional Chinese Medicine(TCM) Hospital","● Location and transportation\n" +
                "Address: No.274, Middle Zhijiang Road (between Tongge Road and Baochang Road)\n" +
                "Metro: Line. 8 to NorthTibet Road Station, going out form the No. 3 exit \n" +
                "Line 3 and line 4 to Baoshan Road Station, No.1 exit \n" +
                "Line 1 to North Zhongshan Road station, No.2 exit.\n" +
                "Bus:  963、1208、69、108、115、140、309、817、305、65、78、302、310、502、537、823、942、952、962\n" +
                "\n" +
                "● Departments");
        map.put("Shanghai TCM-Integrated Hospital","● Location and transportation\n" +
                "Address: No.230，Baoding road , Hongkou District ,Shanghai,\n" +
                "Metro: Dalian Road --Line 4(Exit 3), Line12\n" +
                "Bus：22, 137, 868, 934, Shen Chuan Line\n" +
                "\n" +
                "● Department");
        return map;
    }

    public static List getDetail1(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("Inserting metal needles into certain acupoints through manipulations to regulate the circulation of qi in human body in order to relieve pain and treat diseases. " +
                "The understanding of how acupuncture works has evolved with its practice, but the descriptions set down a thousand years ago have largely been retained. \n \n" +
                "The dominant function of acupuncture is to regulate the circulation of qi (vital energy) and blood. Approximately 2,000 years ago, the pre-eminent acupuncture text, " +
                "Huangdi Neijing (Yellow Emperor's Classic on Internal Medicine), was written. In it, acupuncture was described as a means of letting out excess qi or blood" +
                " by making holes in the body along certain pathways, called jingluo (meridians). For some of these meridians, it was advised to acupuncture in such a way as " +
                "to let out the blood but not the qi; for others, to let out the qi, but not the blood. \n \n" +
                "Many diseases were thought to enter the body through the skin, and then" +
                " penetrate inward through muscle, internal organs, and, if not cured in timely fashion, to the marrow of the bone. By inserting a needle to the appropriate depth-to " +
                "correspond with the degree of disease penetration-the disease could be let out. \n \n" +
                "Hundreds of clinical studies on the benefits of acupuncture show that it successfully" +
                " treats conditions ranging from musculoskeletal problems (back pain, neck pain, and others) to nausea, migraine headache, anxiety, depression, insomnia, and infertility. ");

        list.add("Moxibustion is a form of heat therapy in which dried plant materials called \"moxa\" are burned on or very near the surface of the skin. The intention is to warm and invigorate the flow of qi in the body and dispel certain pathogenic influences. Moxa is usually made from the dried leafy material of Chinese mugwort (Artemesia argyi or A.vlugaris), but it can be made of other substances as well. \n\n" +
                "There are several methods of moxibustion. Three of them are direct scarring, direct non-scarring, and indirect moxibustion. Direct scarring moxibustion places a small cone of moxa" +
                "on the skin at an acupuncture point and burns it until the skin blisters, which then scars after it heals. Direct non-scarring moxibustion removes the burning moxa" +
                "before the skin burns enough to scar, unless the burning moxa is left on the skin too long. Indirect moxibustion holds a cigar made of moxa near the acupuncture point" +
                "to heat the skin, or holds it on an acupuncture needle inserted in the skin to heat the needle. There is also stick-on moxa. \n\n" +
                "Moxibustion is used for: \n\n" +
                "● Pain due to injury or arthritis, especially in \"cold\" patterns where the pain naturally feels better with the application of heat \n\n" +
                "● Digestive problems and irregular elimination \n\n" +
                "● Gynecological and obstetrical conditions, including breech presentation in late term pregnancy \n\n" +
                "● Protection against cold and flu strains \n\n" +
                "Practitioners often do both acupuncture and moxibustion in the same clinic session when appropriate to the diagnosis and treatment strategy. Practitioners believe that the therapies" +
                "increase each other's effectiveness when used together. \n\n" +
                "Unlike acupuncture, which is almost always done by a trained practitioner in a clinic setting, moxibustion can be easily used at home. It is not uncommon for Chinese medical" +
                "practitioners to train their patients to use moxa on themselves to strengthen the effect of the clinical sessions between appointments. \n");

        list.add("Gua sha is a natural, alternative therapy that involves scraping your skin with a massage tool to improve your circulation. This ancient Chinese healing technique may" +
                "offer a unique approach to better health, addressing issues like chronic pain. \n\n" +
                "A technician scrapes your skin with short or long strokes to stimulate microcirculation of the soft tissue, which increases blood flow. They make these strokes with a smooth-edged" +
                "instrument known as a gua massage tool. The technician applies massage oil to your skin, and then uses the tool to repeatedly scrape your skin in a downward motion. \n\n" +
                "Gua sha is intended to address stagnant energy, called qi, in the body that practitioners believe may be responsible for inflammation. Inflammation is the underlying cause of" +
                "several conditions associated with chronic pain. Rubbing the skin’s surface is thought to help break up this energy, reduce inflammation, and promote healing. \n\n" +
                "Gua sha is generally performed on a person’s back, buttocks, neck, arms, and legs. A gentle version of it is even used on the face as a facial technique. Your technician may apply" +
                "mild pressure, and gradually increase intensity to determine how much force you can handle. \n\n" +
                "Gua sha is most often used to relieve muscle and joint pain. Conditions of the muscles and bones are known as musculoskeletal disorders. Some examples include back pain, tendon" +
                "strain, and carpal tunnel syndrome.Practitioners claim that gua sha can also benefit the immune system and reduce inflammation. Sometimes, gua sha is used to treat a" +
                "cold, fever, or problems with the lungs. Small injuries to the body, such as the bruises caused by gua sha, are sometimes known as microtrauma. These create a response" +
                "in the body that may help to break up scar tissue. Microtrauma may also help with fibrosis, which is a buildup of too much connective " +
                "tissue when the body heals. \n");

        list.add("Medicines that are gathered, processed, prepared, and can be explained based on the theories of traditional Chinese medicine (TCM) are called Chinese herbal medicines." +
                "In other words, Chinese herbs are the substances that are used to prevent, treat, and diagnose diseases under the guidance of TCM theories and with functions of" +
                "rehabilitation and health care. Most of the herbs come from natural materials and their processed products, including herbs, animals, minerals, and some chemical" +
                "and biological products, but most of them are herbs. \n\n" +
                "The TCM philosophy proposes that everything including organs of the body - is composed of the five elements: fire, earth, metal, water and wood. The herbs are similarly classified" +
                "into the five tastes - sweet, salty, bitter, pungent and sour - which correspond to the five elements, for example, since the skin is a metal element Yang organ, it" +
                "would be treated with a pungent herb. \n\n" +
                "Chinese herbal medicines are mainly plant based, but some preparations include minerals or animal products. They can be packaged as powders, pastes, lotions or tablets, depending" +
                "on the herb and its intended use. Different herbs have different properties and can balance particular parts of the body. Prescribing a particular herb or concoction" +
                "of herbs means the practitioner’s diagnosis has to take into account the state of the patient’s Yin and Yang, and the elements that are governing the affected organs. \n\n" +
                "The most valuable benefit of an herbal consultation is the carefully blended combination of herbs specifically designed to address each person’s unique set of needs. You can" +
                "benefit if you are: \n\n" +
                "● Looking for greater balance and harmony \n\n" +
                "● A person with an acute or chronic condition such as allergies, asthma, migraines, IBS and insomnia \n\n" +
                "● Someone with emotional challenges such as anxiety, stress, fear, addictions, anger, grief, or depression \n\n" +
                "● Looking for caring and compassionate practitioners who listen \n\n" +
                "● Ready for an alternative, yet proven solution to health issues. \n");

        list.add("Tuina is a hands-on body treatment to bring the eight principles of Traditional Chinese Medicine (TCM) into balance. The practitioner may brush, knead, roll, press," +
                "and rub the areas between each of the joints to attempt to circulate the body's defensive qi and get the energy moving in the meridians and the muscles. Techniques may" +
                "be gentle or quite firm. The name comes from two of the actions: tui means \"to push\" and na means \"to lift and squeeze.\n\n" +
                "Tuina is not generally used for pleasure and relaxation, but rather as a treatment to address specific patterns of disharmony. As such, practitioners use it for many of the same" +
                "reasons and according to the same principles as acupuncture. Like acupuncture, TCM uses tui na to harmonize yin and yang in the body by manipulating the qi in the" +
                "acupuncture channels. \n\n" +
                "Tuina includes what is popularly known as \"acupressure,\" where practitioners use finger pressure instead of needles to stimulate the acupuncture points. Tuina is one of the most" +
                "popular TCM treatment modalities and is frequently used in the treatment of superficial trauma and injury and a wide variety of musculoskeletal problems. Tui na is" +
                "also often used when acupuncture is inappropriate, such as with children, when it is referred to as \"Chinese pediatric massage therapy.\" \n\n" +
                "TCM practitioners will frequently encourage and instruct patients to do self-massage and certain exercises at home. This solidifies and expands the benefits created during treatment" +
                "sessions. Self-massage and stretching are considered important aspects of self-healthcare. \n");

        list.add("Cupping is a type of alternative therapy that originated in China. It involves placing cups on the skin to create suction. The suction facilitates healing with blood" +
                "flow, as well as the flow of “qi” in the body. Qi is a Chinese word meaning life force. \n\n" +
                "Cupping increases blood circulation to the area where the cups are placed. This can relieve muscle tension, which can improve overall blood flow and promote cell repair. It can" +
                "also help form new connective tissues and create new blood vessels in the tissue. People use cupping to complement their care for a host of ailments and conditions. \n\n" +
                "Cupping was originally performed using animal horns. Later the “cups” were made from bamboo and then ceramic. The suction was primarily created through the use of heat. The cups" +
                "were originally heated with fire and then applied to the skin. As they cooled, the cups drew the skin inside. \n\n" +
                "Modern cupping is often performed using glass cups that are rounded like balls and open on one end. There are two main categories of cupping performed today: \n\n" +
                "● dry cupping, which is a suction-only method \n\n" +
                "● wet cupping, which may involve both suction and controlled medicinal bleeding \n\n" +
                "Your practitioner, your medical condition, and your preferences will help determine what method is used. \n\n" +
                "The benefits of cupping include local pain relief and muscle relaxation. Cupping improves overall health by removing the energy blockages that TCM practitioners identify as" +
                "barriers to the flow of healthy energy or qi. For athletes, cupping may help increase blood flow to a particular muscle region or help reduce pain. Numerous athletes" +
                "from the Olympics in Rio 2016 used cupping. This was easily seen by circular markings on some of the U.S. swim team members. \n");
        return list;
    }

}
