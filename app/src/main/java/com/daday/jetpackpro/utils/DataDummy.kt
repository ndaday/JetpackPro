package com.daday.jetpackpro.utils

import com.daday.jetpackpro.data.source.local.entity.DataEntity
import com.daday.jetpackpro.data.source.remote.response.ContentResponse

object DataDummy {

    fun generateDummyMovies(): List<DataEntity> {
        val movies = ArrayList<DataEntity>()

        movies.add(
            DataEntity("m1",
                "A Star is Born",
                "October 5, 2018",
                "75",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"
            )
        )
        movies.add(
            DataEntity("m2",
                "Aquaman",
                "December 21, 2018",
                "68",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"
            )
        )
        movies.add(
            DataEntity("m3",
                "Avenger: Invinity War",
                "April 27, 2018",
                "83",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        movies.add(
            DataEntity("m4",
                "Bohemian Rhapsody",
                "November 2, 2018",
                "80",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            DataEntity("m5",
                "Creed II",
                "November 21, 2018",
                "67",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )
        movies.add(
            DataEntity("m6",
                "Glass",
                "January 3, 2019",
                "77",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )
        movies.add(
            DataEntity("m7",
                "How To Train Your Dragon: The Hidden World",
                "January 16, 2019",
                "66",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )
        movies.add(
            DataEntity("m8",
                "Mortal Engine",
                "November 27, 2018",
                "61",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )
        movies.add(
            DataEntity("m9",
                "Robin Hood",
                "November 21, 2018",
                "58",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"
            )
        )
        movies.add(
            DataEntity("m10",
                "Spider-man",
                "May 5, 2002",
                "72",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gh4cZbhZxyTbgxQPxD0dOudNPTn.jpg"
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<DataEntity> {
        val tvShows = ArrayList<DataEntity>()

        tvShows.add(
            DataEntity("tv1",
                "Arrow",
                "October 10, 2012",
                "58",
                "\"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\"",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv2",
                "Doom Patrol",
                "February 15, 2019",
                "65",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv3",
                "Family Guy",
                "January 31, 1999",
                "65",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv4",
                "The Flash",
                "October 7, 2014",
                "67",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv5",
                "Gotham",
                "September 22, 2014",
                "69",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv6",
                "Grey Anatomy",
                "March 27, 2005",
                "64",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv7",
                "Iron Fist",
                "March 17, 2017",
                "61",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rioMBKotMSu2lRIpGAaGRiDauAe.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv8",
                "SuperGirl",
                "October 26, 2015",
                "59",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv9",
                "Supernatural",
                "September 13, 2005",
                "74",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pui1V389cQft0BVFu9pbsYLEW1Q.jpg"
            )
        )
        tvShows.add(
            DataEntity("tv10",
                "The Simpson",
                "December 16, 1989",
                "72",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyMovies(): List<ContentResponse> {
        val movies = ArrayList<ContentResponse>()

        movies.add(
            ContentResponse("m1",
                "A Star is Born",
                "October 5, 2018",
                "75",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"
            )
        )
        movies.add(
            ContentResponse("m2",
                "Aquaman",
                "December 21, 2018",
                "68",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"
            )
        )
        movies.add(
            ContentResponse("m3",
                "Avenger: Invinity War",
                "April 27, 2018",
                "83",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        movies.add(
            ContentResponse("m4",
                "Bohemian Rhapsody",
                "November 2, 2018",
                "80",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            ContentResponse("m5",
                "Creed II",
                "November 21, 2018",
                "67",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )
        movies.add(
            ContentResponse("m6",
                "Glass",
                "January 3, 2019",
                "77",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )
        movies.add(
            ContentResponse("m7",
                "How To Train Your Dragon: The Hidden World",
                "January 16, 2019",
                "66",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )
        movies.add(
            ContentResponse("m8",
                "Mortal Engine",
                "November 27, 2018",
                "61",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )
        movies.add(
            ContentResponse("m9",
                "Robin Hood",
                "November 21, 2018",
                "58",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"
            )
        )
        movies.add(
            ContentResponse("m10",
                "Spider-man",
                "May 5, 2002",
                "72",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gh4cZbhZxyTbgxQPxD0dOudNPTn.jpg"
            )
        )

        return movies
    }

    fun generateRemoteDummyTvShows(): List<ContentResponse> {
        val tvShows = ArrayList<ContentResponse>()

        tvShows.add(
            ContentResponse("tv1",
                "Arrow",
                "October 10, 2012",
                "58",
                "\"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\"",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv2",
                "Doom Patrol",
                "February 15, 2019",
                "65",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv3",
                "Family Guy",
                "January 31, 1999",
                "65",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv4",
                "The Flash",
                "October 7, 2014",
                "67",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv5",
                "Gotham",
                "September 22, 2014",
                "69",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv6",
                "Grey Anatomy",
                "March 27, 2005",
                "64",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv7",
                "Iron Fist",
                "March 17, 2017",
                "61",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rioMBKotMSu2lRIpGAaGRiDauAe.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv8",
                "SuperGirl",
                "October 26, 2015",
                "59",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv9",
                "Supernatural",
                "September 13, 2005",
                "74",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pui1V389cQft0BVFu9pbsYLEW1Q.jpg"
            )
        )
        tvShows.add(
            ContentResponse("tv10",
                "The Simpson",
                "December 16, 1989",
                "72",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"
            )
        )

        return tvShows
    }
}