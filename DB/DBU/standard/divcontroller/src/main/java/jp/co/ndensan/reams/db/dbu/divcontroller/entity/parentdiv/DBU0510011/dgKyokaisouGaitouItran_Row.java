package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Nov 15 11:49:17 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKyokaisouGaitouItran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKyokaisouGaitouItran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">

    private RString shinseiDate;
    private RString ketteiDate;
    private RString sochiGaitoHigaitoKubun;
    private RString kaishiDate;
    private RString shuryoDate;
    private RString kyuhugakuGengakuKisaiKaijo;
    private TextBoxNum hogoFuyoKonkyoGengakuKingaku;
    private RString kyojuhiKeigengoKyoshitsuShurui;
    private TextBoxNum kyojuhiKeigengoFutangaku;
    private TextBoxNum syokuhiKeigengoFutangaku;
    private TextBoxNum yomikaegoKogakuKaigoSetaiJogengaku;
    private RString kaigoHokenryoTeigengoSyotokuDankai;
    private RString kyokaisoSochiKetteiDate;
    private TextBoxNum kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku;
    private TextBoxNum kyojuhiKeigenGengakuJikofutanGetsugaku;
    private RString kyojuhiKeigenFutanGendogakuDankai;
    private RString shokuhiKeigenFutanGendogakuDankai;
    private TextBoxNum riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku;
    private TextBoxNum kaigoHokenryoGengakuGengakuJikofutanGetsugaku;
    private TextBoxNum gengakuJikofutanGetsugakuGokeigaku;
    private RString linkNo;
    private RString shinseiHaishiYMD;
    private RString kyokaisoShomeishoKofuYMD;
    private TextBoxNum shokuhiKeigenGengakuJikofutanGetsugaku;
    private RString sochiGaitoHigaito;
    private RString kyuhugakuGengakuKisaiKaijoFlag;
    private RString kyojuhiKeigengoKyoshitsuShuruiCode;
    private RString hyojunFutanGengakuGaitoFlag;
    private RString kyojuhinadoFutangakugengakuGaitoFlag;
    private RString shokuhiKeigengoHutangakuGaitoFlag;
    private RString kogakuServicehiJogengakuGengakuGaitoFlag;
    private RString kogakuServicehiJogengakuGengakugoJogengaku;
    private RString hokenryoNofuGengakuFlag;
    private RString kyojuhiKeigenFutanGendogakuDankaiCode;
    private RString shokuhiKeigenFutanGendogakuDankaiCode;
    private RString hyojunFutanKeigengoFutangaku;
    private RString rirekiNo;

    public dgKyokaisouGaitouItran_Row() {
        super();
        this.shinseiDate = RString.EMPTY;
        this.ketteiDate = RString.EMPTY;
        this.sochiGaitoHigaitoKubun = RString.EMPTY;
        this.kaishiDate = RString.EMPTY;
        this.shuryoDate = RString.EMPTY;
        this.kyuhugakuGengakuKisaiKaijo = RString.EMPTY;
        this.hogoFuyoKonkyoGengakuKingaku = new TextBoxNum();
        this.kyojuhiKeigengoKyoshitsuShurui = RString.EMPTY;
        this.kyojuhiKeigengoFutangaku = new TextBoxNum();
        this.syokuhiKeigengoFutangaku = new TextBoxNum();
        this.yomikaegoKogakuKaigoSetaiJogengaku = new TextBoxNum();
        this.kaigoHokenryoTeigengoSyotokuDankai = RString.EMPTY;
        this.kyokaisoSochiKetteiDate = RString.EMPTY;
        this.kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku = new TextBoxNum();
        this.kyojuhiKeigenGengakuJikofutanGetsugaku = new TextBoxNum();
        this.kyojuhiKeigenFutanGendogakuDankai = RString.EMPTY;
        this.shokuhiKeigenFutanGendogakuDankai = RString.EMPTY;
        this.riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku = new TextBoxNum();
        this.kaigoHokenryoGengakuGengakuJikofutanGetsugaku = new TextBoxNum();
        this.gengakuJikofutanGetsugakuGokeigaku = new TextBoxNum();
        this.linkNo = RString.EMPTY;
        this.shinseiHaishiYMD = RString.EMPTY;
        this.kyokaisoShomeishoKofuYMD = RString.EMPTY;
        this.shokuhiKeigenGengakuJikofutanGetsugaku = new TextBoxNum();
        this.sochiGaitoHigaito = RString.EMPTY;
        this.kyuhugakuGengakuKisaiKaijoFlag = RString.EMPTY;
        this.kyojuhiKeigengoKyoshitsuShuruiCode = RString.EMPTY;
        this.hyojunFutanGengakuGaitoFlag = RString.EMPTY;
        this.kyojuhinadoFutangakugengakuGaitoFlag = RString.EMPTY;
        this.shokuhiKeigengoHutangakuGaitoFlag = RString.EMPTY;
        this.kogakuServicehiJogengakuGengakuGaitoFlag = RString.EMPTY;
        this.kogakuServicehiJogengakuGengakugoJogengaku = RString.EMPTY;
        this.hokenryoNofuGengakuFlag = RString.EMPTY;
        this.kyojuhiKeigenFutanGendogakuDankaiCode = RString.EMPTY;
        this.shokuhiKeigenFutanGendogakuDankaiCode = RString.EMPTY;
        this.hyojunFutanKeigengoFutangaku = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("sochiGaitoHigaitoKubun", sochiGaitoHigaitoKubun);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("shuryoDate", shuryoDate);
        this.setOriginalData("kyuhugakuGengakuKisaiKaijo", kyuhugakuGengakuKisaiKaijo);
        this.setOriginalData("hogoFuyoKonkyoGengakuKingaku", hogoFuyoKonkyoGengakuKingaku);
        this.setOriginalData("kyojuhiKeigengoKyoshitsuShurui", kyojuhiKeigengoKyoshitsuShurui);
        this.setOriginalData("kyojuhiKeigengoFutangaku", kyojuhiKeigengoFutangaku);
        this.setOriginalData("syokuhiKeigengoFutangaku", syokuhiKeigengoFutangaku);
        this.setOriginalData("yomikaegoKogakuKaigoSetaiJogengaku", yomikaegoKogakuKaigoSetaiJogengaku);
        this.setOriginalData("kaigoHokenryoTeigengoSyotokuDankai", kaigoHokenryoTeigengoSyotokuDankai);
        this.setOriginalData("kyokaisoSochiKetteiDate", kyokaisoSochiKetteiDate);
        this.setOriginalData("kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku", kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku);
        this.setOriginalData("kyojuhiKeigenGengakuJikofutanGetsugaku", kyojuhiKeigenGengakuJikofutanGetsugaku);
        this.setOriginalData("kyojuhiKeigenFutanGendogakuDankai", kyojuhiKeigenFutanGendogakuDankai);
        this.setOriginalData("shokuhiKeigenFutanGendogakuDankai", shokuhiKeigenFutanGendogakuDankai);
        this.setOriginalData("riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku", riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku);
        this.setOriginalData("kaigoHokenryoGengakuGengakuJikofutanGetsugaku", kaigoHokenryoGengakuGengakuJikofutanGetsugaku);
        this.setOriginalData("gengakuJikofutanGetsugakuGokeigaku", gengakuJikofutanGetsugakuGokeigaku);
        this.setOriginalData("linkNo", linkNo);
        this.setOriginalData("shinseiHaishiYMD", shinseiHaishiYMD);
        this.setOriginalData("kyokaisoShomeishoKofuYMD", kyokaisoShomeishoKofuYMD);
        this.setOriginalData("shokuhiKeigenGengakuJikofutanGetsugaku", shokuhiKeigenGengakuJikofutanGetsugaku);
        this.setOriginalData("sochiGaitoHigaito", sochiGaitoHigaito);
        this.setOriginalData("kyuhugakuGengakuKisaiKaijoFlag", kyuhugakuGengakuKisaiKaijoFlag);
        this.setOriginalData("kyojuhiKeigengoKyoshitsuShuruiCode", kyojuhiKeigengoKyoshitsuShuruiCode);
        this.setOriginalData("hyojunFutanGengakuGaitoFlag", hyojunFutanGengakuGaitoFlag);
        this.setOriginalData("kyojuhinadoFutangakugengakuGaitoFlag", kyojuhinadoFutangakugengakuGaitoFlag);
        this.setOriginalData("shokuhiKeigengoHutangakuGaitoFlag", shokuhiKeigengoHutangakuGaitoFlag);
        this.setOriginalData("kogakuServicehiJogengakuGengakuGaitoFlag", kogakuServicehiJogengakuGengakuGaitoFlag);
        this.setOriginalData("kogakuServicehiJogengakuGengakugoJogengaku", kogakuServicehiJogengakuGengakugoJogengaku);
        this.setOriginalData("hokenryoNofuGengakuFlag", hokenryoNofuGengakuFlag);
        this.setOriginalData("kyojuhiKeigenFutanGendogakuDankaiCode", kyojuhiKeigenFutanGendogakuDankaiCode);
        this.setOriginalData("shokuhiKeigenFutanGendogakuDankaiCode", shokuhiKeigenFutanGendogakuDankaiCode);
        this.setOriginalData("hyojunFutanKeigengoFutangaku", hyojunFutanKeigengoFutangaku);
        this.setOriginalData("rirekiNo", rirekiNo);
    }

    public dgKyokaisouGaitouItran_Row(RString shinseiDate, RString ketteiDate, RString sochiGaitoHigaitoKubun, RString kaishiDate, RString shuryoDate, RString kyuhugakuGengakuKisaiKaijo, TextBoxNum hogoFuyoKonkyoGengakuKingaku, RString kyojuhiKeigengoKyoshitsuShurui, TextBoxNum kyojuhiKeigengoFutangaku, TextBoxNum syokuhiKeigengoFutangaku, TextBoxNum yomikaegoKogakuKaigoSetaiJogengaku, RString kaigoHokenryoTeigengoSyotokuDankai, RString kyokaisoSochiKetteiDate, TextBoxNum kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku, TextBoxNum kyojuhiKeigenGengakuJikofutanGetsugaku, RString kyojuhiKeigenFutanGendogakuDankai, RString shokuhiKeigenFutanGendogakuDankai, TextBoxNum riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku, TextBoxNum kaigoHokenryoGengakuGengakuJikofutanGetsugaku, TextBoxNum gengakuJikofutanGetsugakuGokeigaku, RString linkNo, RString shinseiHaishiYMD, RString kyokaisoShomeishoKofuYMD, TextBoxNum shokuhiKeigenGengakuJikofutanGetsugaku, RString sochiGaitoHigaito, RString kyuhugakuGengakuKisaiKaijoFlag, RString kyojuhiKeigengoKyoshitsuShuruiCode, RString hyojunFutanGengakuGaitoFlag, RString kyojuhinadoFutangakugengakuGaitoFlag, RString shokuhiKeigengoHutangakuGaitoFlag, RString kogakuServicehiJogengakuGengakuGaitoFlag, RString kogakuServicehiJogengakuGengakugoJogengaku, RString hokenryoNofuGengakuFlag, RString kyojuhiKeigenFutanGendogakuDankaiCode, RString shokuhiKeigenFutanGendogakuDankaiCode, RString hyojunFutanKeigengoFutangaku, RString rirekiNo) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("sochiGaitoHigaitoKubun", sochiGaitoHigaitoKubun);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("shuryoDate", shuryoDate);
        this.setOriginalData("kyuhugakuGengakuKisaiKaijo", kyuhugakuGengakuKisaiKaijo);
        this.setOriginalData("hogoFuyoKonkyoGengakuKingaku", hogoFuyoKonkyoGengakuKingaku);
        this.setOriginalData("kyojuhiKeigengoKyoshitsuShurui", kyojuhiKeigengoKyoshitsuShurui);
        this.setOriginalData("kyojuhiKeigengoFutangaku", kyojuhiKeigengoFutangaku);
        this.setOriginalData("syokuhiKeigengoFutangaku", syokuhiKeigengoFutangaku);
        this.setOriginalData("yomikaegoKogakuKaigoSetaiJogengaku", yomikaegoKogakuKaigoSetaiJogengaku);
        this.setOriginalData("kaigoHokenryoTeigengoSyotokuDankai", kaigoHokenryoTeigengoSyotokuDankai);
        this.setOriginalData("kyokaisoSochiKetteiDate", kyokaisoSochiKetteiDate);
        this.setOriginalData("kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku", kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku);
        this.setOriginalData("kyojuhiKeigenGengakuJikofutanGetsugaku", kyojuhiKeigenGengakuJikofutanGetsugaku);
        this.setOriginalData("kyojuhiKeigenFutanGendogakuDankai", kyojuhiKeigenFutanGendogakuDankai);
        this.setOriginalData("shokuhiKeigenFutanGendogakuDankai", shokuhiKeigenFutanGendogakuDankai);
        this.setOriginalData("riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku", riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku);
        this.setOriginalData("kaigoHokenryoGengakuGengakuJikofutanGetsugaku", kaigoHokenryoGengakuGengakuJikofutanGetsugaku);
        this.setOriginalData("gengakuJikofutanGetsugakuGokeigaku", gengakuJikofutanGetsugakuGokeigaku);
        this.setOriginalData("linkNo", linkNo);
        this.setOriginalData("shinseiHaishiYMD", shinseiHaishiYMD);
        this.setOriginalData("kyokaisoShomeishoKofuYMD", kyokaisoShomeishoKofuYMD);
        this.setOriginalData("shokuhiKeigenGengakuJikofutanGetsugaku", shokuhiKeigenGengakuJikofutanGetsugaku);
        this.setOriginalData("sochiGaitoHigaito", sochiGaitoHigaito);
        this.setOriginalData("kyuhugakuGengakuKisaiKaijoFlag", kyuhugakuGengakuKisaiKaijoFlag);
        this.setOriginalData("kyojuhiKeigengoKyoshitsuShuruiCode", kyojuhiKeigengoKyoshitsuShuruiCode);
        this.setOriginalData("hyojunFutanGengakuGaitoFlag", hyojunFutanGengakuGaitoFlag);
        this.setOriginalData("kyojuhinadoFutangakugengakuGaitoFlag", kyojuhinadoFutangakugengakuGaitoFlag);
        this.setOriginalData("shokuhiKeigengoHutangakuGaitoFlag", shokuhiKeigengoHutangakuGaitoFlag);
        this.setOriginalData("kogakuServicehiJogengakuGengakuGaitoFlag", kogakuServicehiJogengakuGengakuGaitoFlag);
        this.setOriginalData("kogakuServicehiJogengakuGengakugoJogengaku", kogakuServicehiJogengakuGengakugoJogengaku);
        this.setOriginalData("hokenryoNofuGengakuFlag", hokenryoNofuGengakuFlag);
        this.setOriginalData("kyojuhiKeigenFutanGendogakuDankaiCode", kyojuhiKeigenFutanGendogakuDankaiCode);
        this.setOriginalData("shokuhiKeigenFutanGendogakuDankaiCode", shokuhiKeigenFutanGendogakuDankaiCode);
        this.setOriginalData("hyojunFutanKeigengoFutangaku", hyojunFutanKeigengoFutangaku);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.shinseiDate = shinseiDate;
        this.ketteiDate = ketteiDate;
        this.sochiGaitoHigaitoKubun = sochiGaitoHigaitoKubun;
        this.kaishiDate = kaishiDate;
        this.shuryoDate = shuryoDate;
        this.kyuhugakuGengakuKisaiKaijo = kyuhugakuGengakuKisaiKaijo;
        this.hogoFuyoKonkyoGengakuKingaku = hogoFuyoKonkyoGengakuKingaku;
        this.kyojuhiKeigengoKyoshitsuShurui = kyojuhiKeigengoKyoshitsuShurui;
        this.kyojuhiKeigengoFutangaku = kyojuhiKeigengoFutangaku;
        this.syokuhiKeigengoFutangaku = syokuhiKeigengoFutangaku;
        this.yomikaegoKogakuKaigoSetaiJogengaku = yomikaegoKogakuKaigoSetaiJogengaku;
        this.kaigoHokenryoTeigengoSyotokuDankai = kaigoHokenryoTeigengoSyotokuDankai;
        this.kyokaisoSochiKetteiDate = kyokaisoSochiKetteiDate;
        this.kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku = kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku;
        this.kyojuhiKeigenGengakuJikofutanGetsugaku = kyojuhiKeigenGengakuJikofutanGetsugaku;
        this.kyojuhiKeigenFutanGendogakuDankai = kyojuhiKeigenFutanGendogakuDankai;
        this.shokuhiKeigenFutanGendogakuDankai = shokuhiKeigenFutanGendogakuDankai;
        this.riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku = riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku;
        this.kaigoHokenryoGengakuGengakuJikofutanGetsugaku = kaigoHokenryoGengakuGengakuJikofutanGetsugaku;
        this.gengakuJikofutanGetsugakuGokeigaku = gengakuJikofutanGetsugakuGokeigaku;
        this.linkNo = linkNo;
        this.shinseiHaishiYMD = shinseiHaishiYMD;
        this.kyokaisoShomeishoKofuYMD = kyokaisoShomeishoKofuYMD;
        this.shokuhiKeigenGengakuJikofutanGetsugaku = shokuhiKeigenGengakuJikofutanGetsugaku;
        this.sochiGaitoHigaito = sochiGaitoHigaito;
        this.kyuhugakuGengakuKisaiKaijoFlag = kyuhugakuGengakuKisaiKaijoFlag;
        this.kyojuhiKeigengoKyoshitsuShuruiCode = kyojuhiKeigengoKyoshitsuShuruiCode;
        this.hyojunFutanGengakuGaitoFlag = hyojunFutanGengakuGaitoFlag;
        this.kyojuhinadoFutangakugengakuGaitoFlag = kyojuhinadoFutangakugengakuGaitoFlag;
        this.shokuhiKeigengoHutangakuGaitoFlag = shokuhiKeigengoHutangakuGaitoFlag;
        this.kogakuServicehiJogengakuGengakuGaitoFlag = kogakuServicehiJogengakuGengakuGaitoFlag;
        this.kogakuServicehiJogengakuGengakugoJogengaku = kogakuServicehiJogengakuGengakugoJogengaku;
        this.hokenryoNofuGengakuFlag = hokenryoNofuGengakuFlag;
        this.kyojuhiKeigenFutanGendogakuDankaiCode = kyojuhiKeigenFutanGendogakuDankaiCode;
        this.shokuhiKeigenFutanGendogakuDankaiCode = shokuhiKeigenFutanGendogakuDankaiCode;
        this.hyojunFutanKeigengoFutangaku = hyojunFutanKeigengoFutangaku;
        this.rirekiNo = rirekiNo;
    }

    public RString getShinseiDate() {
        return shinseiDate;
    }

    public RString getKetteiDate() {
        return ketteiDate;
    }

    public RString getSochiGaitoHigaitoKubun() {
        return sochiGaitoHigaitoKubun;
    }

    public RString getKaishiDate() {
        return kaishiDate;
    }

    public RString getShuryoDate() {
        return shuryoDate;
    }

    public RString getKyuhugakuGengakuKisaiKaijo() {
        return kyuhugakuGengakuKisaiKaijo;
    }

    public TextBoxNum getHogoFuyoKonkyoGengakuKingaku() {
        return hogoFuyoKonkyoGengakuKingaku;
    }

    public RString getKyojuhiKeigengoKyoshitsuShurui() {
        return kyojuhiKeigengoKyoshitsuShurui;
    }

    public TextBoxNum getKyojuhiKeigengoFutangaku() {
        return kyojuhiKeigengoFutangaku;
    }

    public TextBoxNum getSyokuhiKeigengoFutangaku() {
        return syokuhiKeigengoFutangaku;
    }

    public TextBoxNum getYomikaegoKogakuKaigoSetaiJogengaku() {
        return yomikaegoKogakuKaigoSetaiJogengaku;
    }

    public RString getKaigoHokenryoTeigengoSyotokuDankai() {
        return kaigoHokenryoTeigengoSyotokuDankai;
    }

    public RString getKyokaisoSochiKetteiDate() {
        return kyokaisoSochiKetteiDate;
    }

    public TextBoxNum getKyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku() {
        return kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku;
    }

    public TextBoxNum getKyojuhiKeigenGengakuJikofutanGetsugaku() {
        return kyojuhiKeigenGengakuJikofutanGetsugaku;
    }

    public RString getKyojuhiKeigenFutanGendogakuDankai() {
        return kyojuhiKeigenFutanGendogakuDankai;
    }

    public RString getShokuhiKeigenFutanGendogakuDankai() {
        return shokuhiKeigenFutanGendogakuDankai;
    }

    public TextBoxNum getRiyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku() {
        return riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku;
    }

    public TextBoxNum getKaigoHokenryoGengakuGengakuJikofutanGetsugaku() {
        return kaigoHokenryoGengakuGengakuJikofutanGetsugaku;
    }

    public TextBoxNum getGengakuJikofutanGetsugakuGokeigaku() {
        return gengakuJikofutanGetsugakuGokeigaku;
    }

    public RString getLinkNo() {
        return linkNo;
    }

    public RString getShinseiHaishiYMD() {
        return shinseiHaishiYMD;
    }

    public RString getKyokaisoShomeishoKofuYMD() {
        return kyokaisoShomeishoKofuYMD;
    }

    public TextBoxNum getShokuhiKeigenGengakuJikofutanGetsugaku() {
        return shokuhiKeigenGengakuJikofutanGetsugaku;
    }

    public RString getSochiGaitoHigaito() {
        return sochiGaitoHigaito;
    }

    public RString getKyuhugakuGengakuKisaiKaijoFlag() {
        return kyuhugakuGengakuKisaiKaijoFlag;
    }

    public RString getKyojuhiKeigengoKyoshitsuShuruiCode() {
        return kyojuhiKeigengoKyoshitsuShuruiCode;
    }

    public RString getHyojunFutanGengakuGaitoFlag() {
        return hyojunFutanGengakuGaitoFlag;
    }

    public RString getKyojuhinadoFutangakugengakuGaitoFlag() {
        return kyojuhinadoFutangakugengakuGaitoFlag;
    }

    public RString getShokuhiKeigengoHutangakuGaitoFlag() {
        return shokuhiKeigengoHutangakuGaitoFlag;
    }

    public RString getKogakuServicehiJogengakuGengakuGaitoFlag() {
        return kogakuServicehiJogengakuGengakuGaitoFlag;
    }

    public RString getKogakuServicehiJogengakuGengakugoJogengaku() {
        return kogakuServicehiJogengakuGengakugoJogengaku;
    }

    public RString getHokenryoNofuGengakuFlag() {
        return hokenryoNofuGengakuFlag;
    }

    public RString getKyojuhiKeigenFutanGendogakuDankaiCode() {
        return kyojuhiKeigenFutanGendogakuDankaiCode;
    }

    public RString getShokuhiKeigenFutanGendogakuDankaiCode() {
        return shokuhiKeigenFutanGendogakuDankaiCode;
    }

    public RString getHyojunFutanKeigengoFutangaku() {
        return hyojunFutanKeigengoFutangaku;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public void setShinseiDate(RString shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setKetteiDate(RString ketteiDate) {
        this.setOriginalData("ketteiDate", ketteiDate);
        this.ketteiDate = ketteiDate;
    }

    public void setSochiGaitoHigaitoKubun(RString sochiGaitoHigaitoKubun) {
        this.setOriginalData("sochiGaitoHigaitoKubun", sochiGaitoHigaitoKubun);
        this.sochiGaitoHigaitoKubun = sochiGaitoHigaitoKubun;
    }

    public void setKaishiDate(RString kaishiDate) {
        this.setOriginalData("kaishiDate", kaishiDate);
        this.kaishiDate = kaishiDate;
    }

    public void setShuryoDate(RString shuryoDate) {
        this.setOriginalData("shuryoDate", shuryoDate);
        this.shuryoDate = shuryoDate;
    }

    public void setKyuhugakuGengakuKisaiKaijo(RString kyuhugakuGengakuKisaiKaijo) {
        this.setOriginalData("kyuhugakuGengakuKisaiKaijo", kyuhugakuGengakuKisaiKaijo);
        this.kyuhugakuGengakuKisaiKaijo = kyuhugakuGengakuKisaiKaijo;
    }

    public void setHogoFuyoKonkyoGengakuKingaku(TextBoxNum hogoFuyoKonkyoGengakuKingaku) {
        this.setOriginalData("hogoFuyoKonkyoGengakuKingaku", hogoFuyoKonkyoGengakuKingaku);
        this.hogoFuyoKonkyoGengakuKingaku = hogoFuyoKonkyoGengakuKingaku;
    }

    public void setKyojuhiKeigengoKyoshitsuShurui(RString kyojuhiKeigengoKyoshitsuShurui) {
        this.setOriginalData("kyojuhiKeigengoKyoshitsuShurui", kyojuhiKeigengoKyoshitsuShurui);
        this.kyojuhiKeigengoKyoshitsuShurui = kyojuhiKeigengoKyoshitsuShurui;
    }

    public void setKyojuhiKeigengoFutangaku(TextBoxNum kyojuhiKeigengoFutangaku) {
        this.setOriginalData("kyojuhiKeigengoFutangaku", kyojuhiKeigengoFutangaku);
        this.kyojuhiKeigengoFutangaku = kyojuhiKeigengoFutangaku;
    }

    public void setSyokuhiKeigengoFutangaku(TextBoxNum syokuhiKeigengoFutangaku) {
        this.setOriginalData("syokuhiKeigengoFutangaku", syokuhiKeigengoFutangaku);
        this.syokuhiKeigengoFutangaku = syokuhiKeigengoFutangaku;
    }

    public void setYomikaegoKogakuKaigoSetaiJogengaku(TextBoxNum yomikaegoKogakuKaigoSetaiJogengaku) {
        this.setOriginalData("yomikaegoKogakuKaigoSetaiJogengaku", yomikaegoKogakuKaigoSetaiJogengaku);
        this.yomikaegoKogakuKaigoSetaiJogengaku = yomikaegoKogakuKaigoSetaiJogengaku;
    }

    public void setKaigoHokenryoTeigengoSyotokuDankai(RString kaigoHokenryoTeigengoSyotokuDankai) {
        this.setOriginalData("kaigoHokenryoTeigengoSyotokuDankai", kaigoHokenryoTeigengoSyotokuDankai);
        this.kaigoHokenryoTeigengoSyotokuDankai = kaigoHokenryoTeigengoSyotokuDankai;
    }

    public void setKyokaisoSochiKetteiDate(RString kyokaisoSochiKetteiDate) {
        this.setOriginalData("kyokaisoSochiKetteiDate", kyokaisoSochiKetteiDate);
        this.kyokaisoSochiKetteiDate = kyokaisoSochiKetteiDate;
    }

    public void setKyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku(TextBoxNum kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku) {
        this.setOriginalData("kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku", kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku);
        this.kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku = kyuhugakuGengakuTorikeshiGengakuJikoFutanGetsugaku;
    }

    public void setKyojuhiKeigenGengakuJikofutanGetsugaku(TextBoxNum kyojuhiKeigenGengakuJikofutanGetsugaku) {
        this.setOriginalData("kyojuhiKeigenGengakuJikofutanGetsugaku", kyojuhiKeigenGengakuJikofutanGetsugaku);
        this.kyojuhiKeigenGengakuJikofutanGetsugaku = kyojuhiKeigenGengakuJikofutanGetsugaku;
    }

    public void setKyojuhiKeigenFutanGendogakuDankai(RString kyojuhiKeigenFutanGendogakuDankai) {
        this.setOriginalData("kyojuhiKeigenFutanGendogakuDankai", kyojuhiKeigenFutanGendogakuDankai);
        this.kyojuhiKeigenFutanGendogakuDankai = kyojuhiKeigenFutanGendogakuDankai;
    }

    public void setShokuhiKeigenFutanGendogakuDankai(RString shokuhiKeigenFutanGendogakuDankai) {
        this.setOriginalData("shokuhiKeigenFutanGendogakuDankai", shokuhiKeigenFutanGendogakuDankai);
        this.shokuhiKeigenFutanGendogakuDankai = shokuhiKeigenFutanGendogakuDankai;
    }

    public void setRiyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku(TextBoxNum riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku) {
        this.setOriginalData("riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku", riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku);
        this.riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku = riyoshaFutanSetaiGassangakuGengakuJikofutanGetsugaku;
    }

    public void setKaigoHokenryoGengakuGengakuJikofutanGetsugaku(TextBoxNum kaigoHokenryoGengakuGengakuJikofutanGetsugaku) {
        this.setOriginalData("kaigoHokenryoGengakuGengakuJikofutanGetsugaku", kaigoHokenryoGengakuGengakuJikofutanGetsugaku);
        this.kaigoHokenryoGengakuGengakuJikofutanGetsugaku = kaigoHokenryoGengakuGengakuJikofutanGetsugaku;
    }

    public void setGengakuJikofutanGetsugakuGokeigaku(TextBoxNum gengakuJikofutanGetsugakuGokeigaku) {
        this.setOriginalData("gengakuJikofutanGetsugakuGokeigaku", gengakuJikofutanGetsugakuGokeigaku);
        this.gengakuJikofutanGetsugakuGokeigaku = gengakuJikofutanGetsugakuGokeigaku;
    }

    public void setLinkNo(RString linkNo) {
        this.setOriginalData("linkNo", linkNo);
        this.linkNo = linkNo;
    }

    public void setShinseiHaishiYMD(RString shinseiHaishiYMD) {
        this.setOriginalData("shinseiHaishiYMD", shinseiHaishiYMD);
        this.shinseiHaishiYMD = shinseiHaishiYMD;
    }

    public void setKyokaisoShomeishoKofuYMD(RString kyokaisoShomeishoKofuYMD) {
        this.setOriginalData("kyokaisoShomeishoKofuYMD", kyokaisoShomeishoKofuYMD);
        this.kyokaisoShomeishoKofuYMD = kyokaisoShomeishoKofuYMD;
    }

    public void setShokuhiKeigenGengakuJikofutanGetsugaku(TextBoxNum shokuhiKeigenGengakuJikofutanGetsugaku) {
        this.setOriginalData("shokuhiKeigenGengakuJikofutanGetsugaku", shokuhiKeigenGengakuJikofutanGetsugaku);
        this.shokuhiKeigenGengakuJikofutanGetsugaku = shokuhiKeigenGengakuJikofutanGetsugaku;
    }

    public void setSochiGaitoHigaito(RString sochiGaitoHigaito) {
        this.setOriginalData("sochiGaitoHigaito", sochiGaitoHigaito);
        this.sochiGaitoHigaito = sochiGaitoHigaito;
    }

    public void setKyuhugakuGengakuKisaiKaijoFlag(RString kyuhugakuGengakuKisaiKaijoFlag) {
        this.setOriginalData("kyuhugakuGengakuKisaiKaijoFlag", kyuhugakuGengakuKisaiKaijoFlag);
        this.kyuhugakuGengakuKisaiKaijoFlag = kyuhugakuGengakuKisaiKaijoFlag;
    }

    public void setKyojuhiKeigengoKyoshitsuShuruiCode(RString kyojuhiKeigengoKyoshitsuShuruiCode) {
        this.setOriginalData("kyojuhiKeigengoKyoshitsuShuruiCode", kyojuhiKeigengoKyoshitsuShuruiCode);
        this.kyojuhiKeigengoKyoshitsuShuruiCode = kyojuhiKeigengoKyoshitsuShuruiCode;
    }

    public void setHyojunFutanGengakuGaitoFlag(RString hyojunFutanGengakuGaitoFlag) {
        this.setOriginalData("hyojunFutanGengakuGaitoFlag", hyojunFutanGengakuGaitoFlag);
        this.hyojunFutanGengakuGaitoFlag = hyojunFutanGengakuGaitoFlag;
    }

    public void setKyojuhinadoFutangakugengakuGaitoFlag(RString kyojuhinadoFutangakugengakuGaitoFlag) {
        this.setOriginalData("kyojuhinadoFutangakugengakuGaitoFlag", kyojuhinadoFutangakugengakuGaitoFlag);
        this.kyojuhinadoFutangakugengakuGaitoFlag = kyojuhinadoFutangakugengakuGaitoFlag;
    }

    public void setShokuhiKeigengoHutangakuGaitoFlag(RString shokuhiKeigengoHutangakuGaitoFlag) {
        this.setOriginalData("shokuhiKeigengoHutangakuGaitoFlag", shokuhiKeigengoHutangakuGaitoFlag);
        this.shokuhiKeigengoHutangakuGaitoFlag = shokuhiKeigengoHutangakuGaitoFlag;
    }

    public void setKogakuServicehiJogengakuGengakuGaitoFlag(RString kogakuServicehiJogengakuGengakuGaitoFlag) {
        this.setOriginalData("kogakuServicehiJogengakuGengakuGaitoFlag", kogakuServicehiJogengakuGengakuGaitoFlag);
        this.kogakuServicehiJogengakuGengakuGaitoFlag = kogakuServicehiJogengakuGengakuGaitoFlag;
    }

    public void setKogakuServicehiJogengakuGengakugoJogengaku(RString kogakuServicehiJogengakuGengakugoJogengaku) {
        this.setOriginalData("kogakuServicehiJogengakuGengakugoJogengaku", kogakuServicehiJogengakuGengakugoJogengaku);
        this.kogakuServicehiJogengakuGengakugoJogengaku = kogakuServicehiJogengakuGengakugoJogengaku;
    }

    public void setHokenryoNofuGengakuFlag(RString hokenryoNofuGengakuFlag) {
        this.setOriginalData("hokenryoNofuGengakuFlag", hokenryoNofuGengakuFlag);
        this.hokenryoNofuGengakuFlag = hokenryoNofuGengakuFlag;
    }

    public void setKyojuhiKeigenFutanGendogakuDankaiCode(RString kyojuhiKeigenFutanGendogakuDankaiCode) {
        this.setOriginalData("kyojuhiKeigenFutanGendogakuDankaiCode", kyojuhiKeigenFutanGendogakuDankaiCode);
        this.kyojuhiKeigenFutanGendogakuDankaiCode = kyojuhiKeigenFutanGendogakuDankaiCode;
    }

    public void setShokuhiKeigenFutanGendogakuDankaiCode(RString shokuhiKeigenFutanGendogakuDankaiCode) {
        this.setOriginalData("shokuhiKeigenFutanGendogakuDankaiCode", shokuhiKeigenFutanGendogakuDankaiCode);
        this.shokuhiKeigenFutanGendogakuDankaiCode = shokuhiKeigenFutanGendogakuDankaiCode;
    }

    public void setHyojunFutanKeigengoFutangaku(RString hyojunFutanKeigengoFutangaku) {
        this.setOriginalData("hyojunFutanKeigengoFutangaku", hyojunFutanKeigengoFutangaku);
        this.hyojunFutanKeigengoFutangaku = hyojunFutanKeigengoFutangaku;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    // </editor-fold>
}
