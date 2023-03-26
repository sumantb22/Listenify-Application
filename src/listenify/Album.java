package listenify;
import java.util.*;
public class Album {
    public String albumName;

    public String artistName;

    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInALbum(String title) {
        //Iterate over the arrayList and match
        //each Song title with title
        for (Song song : songList) {
            if (song.title.compareTo(title) == 0) {
                return true;
            }
        }
        return false;
    }
    public  String  addSongToAlbum(String title, double duration){
        //check if the song is already present we will not add
        //otherwise we will create a new Song and add it to the songList
        if (findSongInALbum(title)==true){
            return "Song is already present";
        }else {
            //I need to create a song object and then add it to songList
            Song newSong = new Song(title,duration);
            songList.add(newSong);
            return "new Song has been added sucessfully";
        }
    }
    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){
        //trackNo is a no in the songlist
        //TrackNo : 1,2,3,4
        //indices :0,1,2,3
        int index = trackNo-1;
        //checking for validity if index

        if (index>=0 && index<this.songList.size()){
            Song song = this.songList.get(index);
            playList.add(song);
            return  "Song added to playlist";
        }
        return "Invalid track no";
    }
    public String addSongToPlayList(String title, LinkedList<Song> playList){
        //i need to find out that Song with that title
        //and put it in the playList
        for (Song song : songList){
            if(song.title==title){
                playList.add(song);
                return "Song has been added successful";
            }
        }
        return "Song doesn't exist";
    }
}