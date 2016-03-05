package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblFirstTokkiJiko")
    private tblFirstTokkiJikoDiv tblFirstTokkiJiko;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("btnFirstTokkiJikoTeikeibun")
    private ButtonDialog btnFirstTokkiJikoTeikeibun;
    @JsonProperty("spSpace11")
    private Space spSpace11;
    @JsonProperty("btnFirstImageMasking")
    private ButtonDialog btnFirstImageMasking;
    @JsonProperty("tblSecondTokkiJiko")
    private tblSecondTokkiJikoDiv tblSecondTokkiJiko;
    @JsonProperty("spSpace2")
    private Space spSpace2;
    @JsonProperty("btnSecondTokkiJikoTeikeibun")
    private ButtonDialog btnSecondTokkiJikoTeikeibun;
    @JsonProperty("spSpace21")
    private Space spSpace21;
    @JsonProperty("btnSecondImageMasking")
    private ButtonDialog btnSecondImageMasking;
    @JsonProperty("tblThirdTokkiJiko")
    private tblThirdTokkiJikoDiv tblThirdTokkiJiko;
    @JsonProperty("spSpace3")
    private Space spSpace3;
    @JsonProperty("btnThirdTokkiJikoTeikeibun")
    private ButtonDialog btnThirdTokkiJikoTeikeibun;
    @JsonProperty("spSpace31")
    private Space spSpace31;
    @JsonProperty("btnThirdImageMasking")
    private ButtonDialog btnThirdImageMasking;
    @JsonProperty("tblFourthTokkiJiko")
    private tblFourthTokkiJikoDiv tblFourthTokkiJiko;
    @JsonProperty("spSpace4")
    private Space spSpace4;
    @JsonProperty("btnFourthTokkiJikoTeikeibun")
    private ButtonDialog btnFourthTokkiJikoTeikeibun;
    @JsonProperty("spSpace41")
    private Space spSpace41;
    @JsonProperty("btnFourthImageMasking")
    private ButtonDialog btnFourthImageMasking;
    @JsonProperty("tblFifthTokkiJiko")
    private tblFifthTokkiJikoDiv tblFifthTokkiJiko;
    @JsonProperty("spSpace5")
    private Space spSpace5;
    @JsonProperty("btnFifthTokkiJikoTeikeibun")
    private ButtonDialog btnFifthTokkiJikoTeikeibun;
    @JsonProperty("spSpace51")
    private Space spSpace51;
    @JsonProperty("btnFifthImageMasking")
    private ButtonDialog btnFifthImageMasking;
    @JsonProperty("btnBeforeTokkiJiko")
    private Button btnBeforeTokkiJiko;
    @JsonProperty("lblTokkiJikoPage")
    private Label lblTokkiJikoPage;
    @JsonProperty("btnAfterTokkiJiko")
    private Button btnAfterTokkiJiko;
    @JsonProperty("hiddenGenbonMasukuKubun1")
    private RString hiddenGenbonMasukuKubun1;
    @JsonProperty("hiddenGenbonMasukuKubun2")
    private RString hiddenGenbonMasukuKubun2;
    @JsonProperty("hiddenGenbonMasukuKubun3")
    private RString hiddenGenbonMasukuKubun3;
    @JsonProperty("hiddenGenbonMasukuKubun4")
    private RString hiddenGenbonMasukuKubun4;
    @JsonProperty("hiddenGenbonMasukuKubun5")
    private RString hiddenGenbonMasukuKubun5;
    @JsonProperty("hiddenShinkiKubun1")
    private RString hiddenShinkiKubun1;
    @JsonProperty("hiddenShinkiKubun2")
    private RString hiddenShinkiKubun2;
    @JsonProperty("hiddenShinkiKubun3")
    private RString hiddenShinkiKubun3;
    @JsonProperty("hiddenShinkiKubun4")
    private RString hiddenShinkiKubun4;
    @JsonProperty("hiddenShinkiKubun5")
    private RString hiddenShinkiKubun5;
    @JsonProperty("hiddenTokkijikoTextImageKubun1")
    private RString hiddenTokkijikoTextImageKubun1;
    @JsonProperty("hiddenTokkijikoTextImageKubun2")
    private RString hiddenTokkijikoTextImageKubun2;
    @JsonProperty("hiddenTokkijikoTextImageKubun3")
    private RString hiddenTokkijikoTextImageKubun3;
    @JsonProperty("hiddenTokkijikoTextImageKubun4")
    private RString hiddenTokkijikoTextImageKubun4;
    @JsonProperty("hiddenTokkijikoTextImageKubun5")
    private RString hiddenTokkijikoTextImageKubun5;
    @JsonProperty("hiddenHensyuuKubun1")
    private RString hiddenHensyuuKubun1;
    @JsonProperty("hiddenHensyuuKubun2")
    private RString hiddenHensyuuKubun2;
    @JsonProperty("hiddenHensyuuKubun3")
    private RString hiddenHensyuuKubun3;
    @JsonProperty("hiddenHensyuuKubun4")
    private RString hiddenHensyuuKubun4;
    @JsonProperty("hiddenHensyuuKubun5")
    private RString hiddenHensyuuKubun5;
    @JsonProperty("hiddenGaikyoTokkiNyurokuMap")
    private RString hiddenGaikyoTokkiNyurokuMap;
    @JsonProperty("hiddenPageNo")
    private RString hiddenPageNo;
    @JsonProperty("hiddenTotalPageCount")
    private RString hiddenTotalPageCount;
    @JsonProperty("hidden登録業務コード")
    private RString hidden登録業務コード;
    @JsonProperty("hidden登録グループコード")
    private RString hidden登録グループコード;
    @JsonProperty("hiddenサンプル文書")
    private RString hiddenサンプル文書;
    @JsonProperty("hiddenChosaKomokuNo1")
    private RString hiddenChosaKomokuNo1;
    @JsonProperty("hiddenChosaKomokuNo2")
    private RString hiddenChosaKomokuNo2;
    @JsonProperty("hiddenChosaKomokuNo3")
    private RString hiddenChosaKomokuNo3;
    @JsonProperty("hiddenChosaKomokuNo4")
    private RString hiddenChosaKomokuNo4;
    @JsonProperty("hiddenChosaKomokuNo5")
    private RString hiddenChosaKomokuNo5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblFirstTokkiJiko
     * @return tblFirstTokkiJiko
     */
    @JsonProperty("tblFirstTokkiJiko")
    public tblFirstTokkiJikoDiv getTblFirstTokkiJiko() {
        return tblFirstTokkiJiko;
    }

    /*
     * settblFirstTokkiJiko
     * @param tblFirstTokkiJiko tblFirstTokkiJiko
     */
    @JsonProperty("tblFirstTokkiJiko")
    public void setTblFirstTokkiJiko(tblFirstTokkiJikoDiv tblFirstTokkiJiko) {
        this.tblFirstTokkiJiko = tblFirstTokkiJiko;
    }

    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
    }

    /*
     * getbtnFirstTokkiJikoTeikeibun
     * @return btnFirstTokkiJikoTeikeibun
     */
    @JsonProperty("btnFirstTokkiJikoTeikeibun")
    public ButtonDialog getBtnFirstTokkiJikoTeikeibun() {
        return btnFirstTokkiJikoTeikeibun;
    }

    /*
     * setbtnFirstTokkiJikoTeikeibun
     * @param btnFirstTokkiJikoTeikeibun btnFirstTokkiJikoTeikeibun
     */
    @JsonProperty("btnFirstTokkiJikoTeikeibun")
    public void setBtnFirstTokkiJikoTeikeibun(ButtonDialog btnFirstTokkiJikoTeikeibun) {
        this.btnFirstTokkiJikoTeikeibun = btnFirstTokkiJikoTeikeibun;
    }

    /*
     * getspSpace11
     * @return spSpace11
     */
    @JsonProperty("spSpace11")
    public Space getSpSpace11() {
        return spSpace11;
    }

    /*
     * setspSpace11
     * @param spSpace11 spSpace11
     */
    @JsonProperty("spSpace11")
    public void setSpSpace11(Space spSpace11) {
        this.spSpace11 = spSpace11;
    }

    /*
     * getbtnFirstImageMasking
     * @return btnFirstImageMasking
     */
    @JsonProperty("btnFirstImageMasking")
    public ButtonDialog getBtnFirstImageMasking() {
        return btnFirstImageMasking;
    }

    /*
     * setbtnFirstImageMasking
     * @param btnFirstImageMasking btnFirstImageMasking
     */
    @JsonProperty("btnFirstImageMasking")
    public void setBtnFirstImageMasking(ButtonDialog btnFirstImageMasking) {
        this.btnFirstImageMasking = btnFirstImageMasking;
    }

    /*
     * gettblSecondTokkiJiko
     * @return tblSecondTokkiJiko
     */
    @JsonProperty("tblSecondTokkiJiko")
    public tblSecondTokkiJikoDiv getTblSecondTokkiJiko() {
        return tblSecondTokkiJiko;
    }

    /*
     * settblSecondTokkiJiko
     * @param tblSecondTokkiJiko tblSecondTokkiJiko
     */
    @JsonProperty("tblSecondTokkiJiko")
    public void setTblSecondTokkiJiko(tblSecondTokkiJikoDiv tblSecondTokkiJiko) {
        this.tblSecondTokkiJiko = tblSecondTokkiJiko;
    }

    /*
     * getspSpace2
     * @return spSpace2
     */
    @JsonProperty("spSpace2")
    public Space getSpSpace2() {
        return spSpace2;
    }

    /*
     * setspSpace2
     * @param spSpace2 spSpace2
     */
    @JsonProperty("spSpace2")
    public void setSpSpace2(Space spSpace2) {
        this.spSpace2 = spSpace2;
    }

    /*
     * getbtnSecondTokkiJikoTeikeibun
     * @return btnSecondTokkiJikoTeikeibun
     */
    @JsonProperty("btnSecondTokkiJikoTeikeibun")
    public ButtonDialog getBtnSecondTokkiJikoTeikeibun() {
        return btnSecondTokkiJikoTeikeibun;
    }

    /*
     * setbtnSecondTokkiJikoTeikeibun
     * @param btnSecondTokkiJikoTeikeibun btnSecondTokkiJikoTeikeibun
     */
    @JsonProperty("btnSecondTokkiJikoTeikeibun")
    public void setBtnSecondTokkiJikoTeikeibun(ButtonDialog btnSecondTokkiJikoTeikeibun) {
        this.btnSecondTokkiJikoTeikeibun = btnSecondTokkiJikoTeikeibun;
    }

    /*
     * getspSpace21
     * @return spSpace21
     */
    @JsonProperty("spSpace21")
    public Space getSpSpace21() {
        return spSpace21;
    }

    /*
     * setspSpace21
     * @param spSpace21 spSpace21
     */
    @JsonProperty("spSpace21")
    public void setSpSpace21(Space spSpace21) {
        this.spSpace21 = spSpace21;
    }

    /*
     * getbtnSecondImageMasking
     * @return btnSecondImageMasking
     */
    @JsonProperty("btnSecondImageMasking")
    public ButtonDialog getBtnSecondImageMasking() {
        return btnSecondImageMasking;
    }

    /*
     * setbtnSecondImageMasking
     * @param btnSecondImageMasking btnSecondImageMasking
     */
    @JsonProperty("btnSecondImageMasking")
    public void setBtnSecondImageMasking(ButtonDialog btnSecondImageMasking) {
        this.btnSecondImageMasking = btnSecondImageMasking;
    }

    /*
     * gettblThirdTokkiJiko
     * @return tblThirdTokkiJiko
     */
    @JsonProperty("tblThirdTokkiJiko")
    public tblThirdTokkiJikoDiv getTblThirdTokkiJiko() {
        return tblThirdTokkiJiko;
    }

    /*
     * settblThirdTokkiJiko
     * @param tblThirdTokkiJiko tblThirdTokkiJiko
     */
    @JsonProperty("tblThirdTokkiJiko")
    public void setTblThirdTokkiJiko(tblThirdTokkiJikoDiv tblThirdTokkiJiko) {
        this.tblThirdTokkiJiko = tblThirdTokkiJiko;
    }

    /*
     * getspSpace3
     * @return spSpace3
     */
    @JsonProperty("spSpace3")
    public Space getSpSpace3() {
        return spSpace3;
    }

    /*
     * setspSpace3
     * @param spSpace3 spSpace3
     */
    @JsonProperty("spSpace3")
    public void setSpSpace3(Space spSpace3) {
        this.spSpace3 = spSpace3;
    }

    /*
     * getbtnThirdTokkiJikoTeikeibun
     * @return btnThirdTokkiJikoTeikeibun
     */
    @JsonProperty("btnThirdTokkiJikoTeikeibun")
    public ButtonDialog getBtnThirdTokkiJikoTeikeibun() {
        return btnThirdTokkiJikoTeikeibun;
    }

    /*
     * setbtnThirdTokkiJikoTeikeibun
     * @param btnThirdTokkiJikoTeikeibun btnThirdTokkiJikoTeikeibun
     */
    @JsonProperty("btnThirdTokkiJikoTeikeibun")
    public void setBtnThirdTokkiJikoTeikeibun(ButtonDialog btnThirdTokkiJikoTeikeibun) {
        this.btnThirdTokkiJikoTeikeibun = btnThirdTokkiJikoTeikeibun;
    }

    /*
     * getspSpace31
     * @return spSpace31
     */
    @JsonProperty("spSpace31")
    public Space getSpSpace31() {
        return spSpace31;
    }

    /*
     * setspSpace31
     * @param spSpace31 spSpace31
     */
    @JsonProperty("spSpace31")
    public void setSpSpace31(Space spSpace31) {
        this.spSpace31 = spSpace31;
    }

    /*
     * getbtnThirdImageMasking
     * @return btnThirdImageMasking
     */
    @JsonProperty("btnThirdImageMasking")
    public ButtonDialog getBtnThirdImageMasking() {
        return btnThirdImageMasking;
    }

    /*
     * setbtnThirdImageMasking
     * @param btnThirdImageMasking btnThirdImageMasking
     */
    @JsonProperty("btnThirdImageMasking")
    public void setBtnThirdImageMasking(ButtonDialog btnThirdImageMasking) {
        this.btnThirdImageMasking = btnThirdImageMasking;
    }

    /*
     * gettblFourthTokkiJiko
     * @return tblFourthTokkiJiko
     */
    @JsonProperty("tblFourthTokkiJiko")
    public tblFourthTokkiJikoDiv getTblFourthTokkiJiko() {
        return tblFourthTokkiJiko;
    }

    /*
     * settblFourthTokkiJiko
     * @param tblFourthTokkiJiko tblFourthTokkiJiko
     */
    @JsonProperty("tblFourthTokkiJiko")
    public void setTblFourthTokkiJiko(tblFourthTokkiJikoDiv tblFourthTokkiJiko) {
        this.tblFourthTokkiJiko = tblFourthTokkiJiko;
    }

    /*
     * getspSpace4
     * @return spSpace4
     */
    @JsonProperty("spSpace4")
    public Space getSpSpace4() {
        return spSpace4;
    }

    /*
     * setspSpace4
     * @param spSpace4 spSpace4
     */
    @JsonProperty("spSpace4")
    public void setSpSpace4(Space spSpace4) {
        this.spSpace4 = spSpace4;
    }

    /*
     * getbtnFourthTokkiJikoTeikeibun
     * @return btnFourthTokkiJikoTeikeibun
     */
    @JsonProperty("btnFourthTokkiJikoTeikeibun")
    public ButtonDialog getBtnFourthTokkiJikoTeikeibun() {
        return btnFourthTokkiJikoTeikeibun;
    }

    /*
     * setbtnFourthTokkiJikoTeikeibun
     * @param btnFourthTokkiJikoTeikeibun btnFourthTokkiJikoTeikeibun
     */
    @JsonProperty("btnFourthTokkiJikoTeikeibun")
    public void setBtnFourthTokkiJikoTeikeibun(ButtonDialog btnFourthTokkiJikoTeikeibun) {
        this.btnFourthTokkiJikoTeikeibun = btnFourthTokkiJikoTeikeibun;
    }

    /*
     * getspSpace41
     * @return spSpace41
     */
    @JsonProperty("spSpace41")
    public Space getSpSpace41() {
        return spSpace41;
    }

    /*
     * setspSpace41
     * @param spSpace41 spSpace41
     */
    @JsonProperty("spSpace41")
    public void setSpSpace41(Space spSpace41) {
        this.spSpace41 = spSpace41;
    }

    /*
     * getbtnFourthImageMasking
     * @return btnFourthImageMasking
     */
    @JsonProperty("btnFourthImageMasking")
    public ButtonDialog getBtnFourthImageMasking() {
        return btnFourthImageMasking;
    }

    /*
     * setbtnFourthImageMasking
     * @param btnFourthImageMasking btnFourthImageMasking
     */
    @JsonProperty("btnFourthImageMasking")
    public void setBtnFourthImageMasking(ButtonDialog btnFourthImageMasking) {
        this.btnFourthImageMasking = btnFourthImageMasking;
    }

    /*
     * gettblFifthTokkiJiko
     * @return tblFifthTokkiJiko
     */
    @JsonProperty("tblFifthTokkiJiko")
    public tblFifthTokkiJikoDiv getTblFifthTokkiJiko() {
        return tblFifthTokkiJiko;
    }

    /*
     * settblFifthTokkiJiko
     * @param tblFifthTokkiJiko tblFifthTokkiJiko
     */
    @JsonProperty("tblFifthTokkiJiko")
    public void setTblFifthTokkiJiko(tblFifthTokkiJikoDiv tblFifthTokkiJiko) {
        this.tblFifthTokkiJiko = tblFifthTokkiJiko;
    }

    /*
     * getspSpace5
     * @return spSpace5
     */
    @JsonProperty("spSpace5")
    public Space getSpSpace5() {
        return spSpace5;
    }

    /*
     * setspSpace5
     * @param spSpace5 spSpace5
     */
    @JsonProperty("spSpace5")
    public void setSpSpace5(Space spSpace5) {
        this.spSpace5 = spSpace5;
    }

    /*
     * getbtnFifthTokkiJikoTeikeibun
     * @return btnFifthTokkiJikoTeikeibun
     */
    @JsonProperty("btnFifthTokkiJikoTeikeibun")
    public ButtonDialog getBtnFifthTokkiJikoTeikeibun() {
        return btnFifthTokkiJikoTeikeibun;
    }

    /*
     * setbtnFifthTokkiJikoTeikeibun
     * @param btnFifthTokkiJikoTeikeibun btnFifthTokkiJikoTeikeibun
     */
    @JsonProperty("btnFifthTokkiJikoTeikeibun")
    public void setBtnFifthTokkiJikoTeikeibun(ButtonDialog btnFifthTokkiJikoTeikeibun) {
        this.btnFifthTokkiJikoTeikeibun = btnFifthTokkiJikoTeikeibun;
    }

    /*
     * getspSpace51
     * @return spSpace51
     */
    @JsonProperty("spSpace51")
    public Space getSpSpace51() {
        return spSpace51;
    }

    /*
     * setspSpace51
     * @param spSpace51 spSpace51
     */
    @JsonProperty("spSpace51")
    public void setSpSpace51(Space spSpace51) {
        this.spSpace51 = spSpace51;
    }

    /*
     * getbtnFifthImageMasking
     * @return btnFifthImageMasking
     */
    @JsonProperty("btnFifthImageMasking")
    public ButtonDialog getBtnFifthImageMasking() {
        return btnFifthImageMasking;
    }

    /*
     * setbtnFifthImageMasking
     * @param btnFifthImageMasking btnFifthImageMasking
     */
    @JsonProperty("btnFifthImageMasking")
    public void setBtnFifthImageMasking(ButtonDialog btnFifthImageMasking) {
        this.btnFifthImageMasking = btnFifthImageMasking;
    }

    /*
     * getbtnBeforeTokkiJiko
     * @return btnBeforeTokkiJiko
     */
    @JsonProperty("btnBeforeTokkiJiko")
    public Button getBtnBeforeTokkiJiko() {
        return btnBeforeTokkiJiko;
    }

    /*
     * setbtnBeforeTokkiJiko
     * @param btnBeforeTokkiJiko btnBeforeTokkiJiko
     */
    @JsonProperty("btnBeforeTokkiJiko")
    public void setBtnBeforeTokkiJiko(Button btnBeforeTokkiJiko) {
        this.btnBeforeTokkiJiko = btnBeforeTokkiJiko;
    }

    /*
     * getlblTokkiJikoPage
     * @return lblTokkiJikoPage
     */
    @JsonProperty("lblTokkiJikoPage")
    public Label getLblTokkiJikoPage() {
        return lblTokkiJikoPage;
    }

    /*
     * setlblTokkiJikoPage
     * @param lblTokkiJikoPage lblTokkiJikoPage
     */
    @JsonProperty("lblTokkiJikoPage")
    public void setLblTokkiJikoPage(Label lblTokkiJikoPage) {
        this.lblTokkiJikoPage = lblTokkiJikoPage;
    }

    /*
     * getbtnAfterTokkiJiko
     * @return btnAfterTokkiJiko
     */
    @JsonProperty("btnAfterTokkiJiko")
    public Button getBtnAfterTokkiJiko() {
        return btnAfterTokkiJiko;
    }

    /*
     * setbtnAfterTokkiJiko
     * @param btnAfterTokkiJiko btnAfterTokkiJiko
     */
    @JsonProperty("btnAfterTokkiJiko")
    public void setBtnAfterTokkiJiko(Button btnAfterTokkiJiko) {
        this.btnAfterTokkiJiko = btnAfterTokkiJiko;
    }

    /*
     * gethiddenGenbonMasukuKubun1
     * @return hiddenGenbonMasukuKubun1
     */
    @JsonProperty("hiddenGenbonMasukuKubun1")
    public RString getHiddenGenbonMasukuKubun1() {
        return hiddenGenbonMasukuKubun1;
    }

    /*
     * sethiddenGenbonMasukuKubun1
     * @param hiddenGenbonMasukuKubun1 hiddenGenbonMasukuKubun1
     */
    @JsonProperty("hiddenGenbonMasukuKubun1")
    public void setHiddenGenbonMasukuKubun1(RString hiddenGenbonMasukuKubun1) {
        this.hiddenGenbonMasukuKubun1 = hiddenGenbonMasukuKubun1;
    }

    /*
     * gethiddenGenbonMasukuKubun2
     * @return hiddenGenbonMasukuKubun2
     */
    @JsonProperty("hiddenGenbonMasukuKubun2")
    public RString getHiddenGenbonMasukuKubun2() {
        return hiddenGenbonMasukuKubun2;
    }

    /*
     * sethiddenGenbonMasukuKubun2
     * @param hiddenGenbonMasukuKubun2 hiddenGenbonMasukuKubun2
     */
    @JsonProperty("hiddenGenbonMasukuKubun2")
    public void setHiddenGenbonMasukuKubun2(RString hiddenGenbonMasukuKubun2) {
        this.hiddenGenbonMasukuKubun2 = hiddenGenbonMasukuKubun2;
    }

    /*
     * gethiddenGenbonMasukuKubun3
     * @return hiddenGenbonMasukuKubun3
     */
    @JsonProperty("hiddenGenbonMasukuKubun3")
    public RString getHiddenGenbonMasukuKubun3() {
        return hiddenGenbonMasukuKubun3;
    }

    /*
     * sethiddenGenbonMasukuKubun3
     * @param hiddenGenbonMasukuKubun3 hiddenGenbonMasukuKubun3
     */
    @JsonProperty("hiddenGenbonMasukuKubun3")
    public void setHiddenGenbonMasukuKubun3(RString hiddenGenbonMasukuKubun3) {
        this.hiddenGenbonMasukuKubun3 = hiddenGenbonMasukuKubun3;
    }

    /*
     * gethiddenGenbonMasukuKubun4
     * @return hiddenGenbonMasukuKubun4
     */
    @JsonProperty("hiddenGenbonMasukuKubun4")
    public RString getHiddenGenbonMasukuKubun4() {
        return hiddenGenbonMasukuKubun4;
    }

    /*
     * sethiddenGenbonMasukuKubun4
     * @param hiddenGenbonMasukuKubun4 hiddenGenbonMasukuKubun4
     */
    @JsonProperty("hiddenGenbonMasukuKubun4")
    public void setHiddenGenbonMasukuKubun4(RString hiddenGenbonMasukuKubun4) {
        this.hiddenGenbonMasukuKubun4 = hiddenGenbonMasukuKubun4;
    }

    /*
     * gethiddenGenbonMasukuKubun5
     * @return hiddenGenbonMasukuKubun5
     */
    @JsonProperty("hiddenGenbonMasukuKubun5")
    public RString getHiddenGenbonMasukuKubun5() {
        return hiddenGenbonMasukuKubun5;
    }

    /*
     * sethiddenGenbonMasukuKubun5
     * @param hiddenGenbonMasukuKubun5 hiddenGenbonMasukuKubun5
     */
    @JsonProperty("hiddenGenbonMasukuKubun5")
    public void setHiddenGenbonMasukuKubun5(RString hiddenGenbonMasukuKubun5) {
        this.hiddenGenbonMasukuKubun5 = hiddenGenbonMasukuKubun5;
    }

    /*
     * gethiddenShinkiKubun1
     * @return hiddenShinkiKubun1
     */
    @JsonProperty("hiddenShinkiKubun1")
    public RString getHiddenShinkiKubun1() {
        return hiddenShinkiKubun1;
    }

    /*
     * sethiddenShinkiKubun1
     * @param hiddenShinkiKubun1 hiddenShinkiKubun1
     */
    @JsonProperty("hiddenShinkiKubun1")
    public void setHiddenShinkiKubun1(RString hiddenShinkiKubun1) {
        this.hiddenShinkiKubun1 = hiddenShinkiKubun1;
    }

    /*
     * gethiddenShinkiKubun2
     * @return hiddenShinkiKubun2
     */
    @JsonProperty("hiddenShinkiKubun2")
    public RString getHiddenShinkiKubun2() {
        return hiddenShinkiKubun2;
    }

    /*
     * sethiddenShinkiKubun2
     * @param hiddenShinkiKubun2 hiddenShinkiKubun2
     */
    @JsonProperty("hiddenShinkiKubun2")
    public void setHiddenShinkiKubun2(RString hiddenShinkiKubun2) {
        this.hiddenShinkiKubun2 = hiddenShinkiKubun2;
    }

    /*
     * gethiddenShinkiKubun3
     * @return hiddenShinkiKubun3
     */
    @JsonProperty("hiddenShinkiKubun3")
    public RString getHiddenShinkiKubun3() {
        return hiddenShinkiKubun3;
    }

    /*
     * sethiddenShinkiKubun3
     * @param hiddenShinkiKubun3 hiddenShinkiKubun3
     */
    @JsonProperty("hiddenShinkiKubun3")
    public void setHiddenShinkiKubun3(RString hiddenShinkiKubun3) {
        this.hiddenShinkiKubun3 = hiddenShinkiKubun3;
    }

    /*
     * gethiddenShinkiKubun4
     * @return hiddenShinkiKubun4
     */
    @JsonProperty("hiddenShinkiKubun4")
    public RString getHiddenShinkiKubun4() {
        return hiddenShinkiKubun4;
    }

    /*
     * sethiddenShinkiKubun4
     * @param hiddenShinkiKubun4 hiddenShinkiKubun4
     */
    @JsonProperty("hiddenShinkiKubun4")
    public void setHiddenShinkiKubun4(RString hiddenShinkiKubun4) {
        this.hiddenShinkiKubun4 = hiddenShinkiKubun4;
    }

    /*
     * gethiddenShinkiKubun5
     * @return hiddenShinkiKubun5
     */
    @JsonProperty("hiddenShinkiKubun5")
    public RString getHiddenShinkiKubun5() {
        return hiddenShinkiKubun5;
    }

    /*
     * sethiddenShinkiKubun5
     * @param hiddenShinkiKubun5 hiddenShinkiKubun5
     */
    @JsonProperty("hiddenShinkiKubun5")
    public void setHiddenShinkiKubun5(RString hiddenShinkiKubun5) {
        this.hiddenShinkiKubun5 = hiddenShinkiKubun5;
    }

    /*
     * gethiddenTokkijikoTextImageKubun1
     * @return hiddenTokkijikoTextImageKubun1
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun1")
    public RString getHiddenTokkijikoTextImageKubun1() {
        return hiddenTokkijikoTextImageKubun1;
    }

    /*
     * sethiddenTokkijikoTextImageKubun1
     * @param hiddenTokkijikoTextImageKubun1 hiddenTokkijikoTextImageKubun1
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun1")
    public void setHiddenTokkijikoTextImageKubun1(RString hiddenTokkijikoTextImageKubun1) {
        this.hiddenTokkijikoTextImageKubun1 = hiddenTokkijikoTextImageKubun1;
    }

    /*
     * gethiddenTokkijikoTextImageKubun2
     * @return hiddenTokkijikoTextImageKubun2
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun2")
    public RString getHiddenTokkijikoTextImageKubun2() {
        return hiddenTokkijikoTextImageKubun2;
    }

    /*
     * sethiddenTokkijikoTextImageKubun2
     * @param hiddenTokkijikoTextImageKubun2 hiddenTokkijikoTextImageKubun2
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun2")
    public void setHiddenTokkijikoTextImageKubun2(RString hiddenTokkijikoTextImageKubun2) {
        this.hiddenTokkijikoTextImageKubun2 = hiddenTokkijikoTextImageKubun2;
    }

    /*
     * gethiddenTokkijikoTextImageKubun3
     * @return hiddenTokkijikoTextImageKubun3
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun3")
    public RString getHiddenTokkijikoTextImageKubun3() {
        return hiddenTokkijikoTextImageKubun3;
    }

    /*
     * sethiddenTokkijikoTextImageKubun3
     * @param hiddenTokkijikoTextImageKubun3 hiddenTokkijikoTextImageKubun3
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun3")
    public void setHiddenTokkijikoTextImageKubun3(RString hiddenTokkijikoTextImageKubun3) {
        this.hiddenTokkijikoTextImageKubun3 = hiddenTokkijikoTextImageKubun3;
    }

    /*
     * gethiddenTokkijikoTextImageKubun4
     * @return hiddenTokkijikoTextImageKubun4
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun4")
    public RString getHiddenTokkijikoTextImageKubun4() {
        return hiddenTokkijikoTextImageKubun4;
    }

    /*
     * sethiddenTokkijikoTextImageKubun4
     * @param hiddenTokkijikoTextImageKubun4 hiddenTokkijikoTextImageKubun4
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun4")
    public void setHiddenTokkijikoTextImageKubun4(RString hiddenTokkijikoTextImageKubun4) {
        this.hiddenTokkijikoTextImageKubun4 = hiddenTokkijikoTextImageKubun4;
    }

    /*
     * gethiddenTokkijikoTextImageKubun5
     * @return hiddenTokkijikoTextImageKubun5
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun5")
    public RString getHiddenTokkijikoTextImageKubun5() {
        return hiddenTokkijikoTextImageKubun5;
    }

    /*
     * sethiddenTokkijikoTextImageKubun5
     * @param hiddenTokkijikoTextImageKubun5 hiddenTokkijikoTextImageKubun5
     */
    @JsonProperty("hiddenTokkijikoTextImageKubun5")
    public void setHiddenTokkijikoTextImageKubun5(RString hiddenTokkijikoTextImageKubun5) {
        this.hiddenTokkijikoTextImageKubun5 = hiddenTokkijikoTextImageKubun5;
    }

    /*
     * gethiddenHensyuuKubun1
     * @return hiddenHensyuuKubun1
     */
    @JsonProperty("hiddenHensyuuKubun1")
    public RString getHiddenHensyuuKubun1() {
        return hiddenHensyuuKubun1;
    }

    /*
     * sethiddenHensyuuKubun1
     * @param hiddenHensyuuKubun1 hiddenHensyuuKubun1
     */
    @JsonProperty("hiddenHensyuuKubun1")
    public void setHiddenHensyuuKubun1(RString hiddenHensyuuKubun1) {
        this.hiddenHensyuuKubun1 = hiddenHensyuuKubun1;
    }

    /*
     * gethiddenHensyuuKubun2
     * @return hiddenHensyuuKubun2
     */
    @JsonProperty("hiddenHensyuuKubun2")
    public RString getHiddenHensyuuKubun2() {
        return hiddenHensyuuKubun2;
    }

    /*
     * sethiddenHensyuuKubun2
     * @param hiddenHensyuuKubun2 hiddenHensyuuKubun2
     */
    @JsonProperty("hiddenHensyuuKubun2")
    public void setHiddenHensyuuKubun2(RString hiddenHensyuuKubun2) {
        this.hiddenHensyuuKubun2 = hiddenHensyuuKubun2;
    }

    /*
     * gethiddenHensyuuKubun3
     * @return hiddenHensyuuKubun3
     */
    @JsonProperty("hiddenHensyuuKubun3")
    public RString getHiddenHensyuuKubun3() {
        return hiddenHensyuuKubun3;
    }

    /*
     * sethiddenHensyuuKubun3
     * @param hiddenHensyuuKubun3 hiddenHensyuuKubun3
     */
    @JsonProperty("hiddenHensyuuKubun3")
    public void setHiddenHensyuuKubun3(RString hiddenHensyuuKubun3) {
        this.hiddenHensyuuKubun3 = hiddenHensyuuKubun3;
    }

    /*
     * gethiddenHensyuuKubun4
     * @return hiddenHensyuuKubun4
     */
    @JsonProperty("hiddenHensyuuKubun4")
    public RString getHiddenHensyuuKubun4() {
        return hiddenHensyuuKubun4;
    }

    /*
     * sethiddenHensyuuKubun4
     * @param hiddenHensyuuKubun4 hiddenHensyuuKubun4
     */
    @JsonProperty("hiddenHensyuuKubun4")
    public void setHiddenHensyuuKubun4(RString hiddenHensyuuKubun4) {
        this.hiddenHensyuuKubun4 = hiddenHensyuuKubun4;
    }

    /*
     * gethiddenHensyuuKubun5
     * @return hiddenHensyuuKubun5
     */
    @JsonProperty("hiddenHensyuuKubun5")
    public RString getHiddenHensyuuKubun5() {
        return hiddenHensyuuKubun5;
    }

    /*
     * sethiddenHensyuuKubun5
     * @param hiddenHensyuuKubun5 hiddenHensyuuKubun5
     */
    @JsonProperty("hiddenHensyuuKubun5")
    public void setHiddenHensyuuKubun5(RString hiddenHensyuuKubun5) {
        this.hiddenHensyuuKubun5 = hiddenHensyuuKubun5;
    }

    /*
     * gethiddenGaikyoTokkiNyurokuMap
     * @return hiddenGaikyoTokkiNyurokuMap
     */
    @JsonProperty("hiddenGaikyoTokkiNyurokuMap")
    public RString getHiddenGaikyoTokkiNyurokuMap() {
        return hiddenGaikyoTokkiNyurokuMap;
    }

    /*
     * sethiddenGaikyoTokkiNyurokuMap
     * @param hiddenGaikyoTokkiNyurokuMap hiddenGaikyoTokkiNyurokuMap
     */
    @JsonProperty("hiddenGaikyoTokkiNyurokuMap")
    public void setHiddenGaikyoTokkiNyurokuMap(RString hiddenGaikyoTokkiNyurokuMap) {
        this.hiddenGaikyoTokkiNyurokuMap = hiddenGaikyoTokkiNyurokuMap;
    }

    /*
     * gethiddenPageNo
     * @return hiddenPageNo
     */
    @JsonProperty("hiddenPageNo")
    public RString getHiddenPageNo() {
        return hiddenPageNo;
    }

    /*
     * sethiddenPageNo
     * @param hiddenPageNo hiddenPageNo
     */
    @JsonProperty("hiddenPageNo")
    public void setHiddenPageNo(RString hiddenPageNo) {
        this.hiddenPageNo = hiddenPageNo;
    }

    /*
     * gethiddenTotalPageCount
     * @return hiddenTotalPageCount
     */
    @JsonProperty("hiddenTotalPageCount")
    public RString getHiddenTotalPageCount() {
        return hiddenTotalPageCount;
    }

    /*
     * sethiddenTotalPageCount
     * @param hiddenTotalPageCount hiddenTotalPageCount
     */
    @JsonProperty("hiddenTotalPageCount")
    public void setHiddenTotalPageCount(RString hiddenTotalPageCount) {
        this.hiddenTotalPageCount = hiddenTotalPageCount;
    }

    /*
     * gethidden登録業務コード
     * @return hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public RString getHidden登録業務コード() {
        return hidden登録業務コード;
    }

    /*
     * sethidden登録業務コード
     * @param hidden登録業務コード hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public void setHidden登録業務コード(RString hidden登録業務コード) {
        this.hidden登録業務コード = hidden登録業務コード;
    }

    /*
     * gethidden登録グループコード
     * @return hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public RString getHidden登録グループコード() {
        return hidden登録グループコード;
    }

    /*
     * sethidden登録グループコード
     * @param hidden登録グループコード hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public void setHidden登録グループコード(RString hidden登録グループコード) {
        this.hidden登録グループコード = hidden登録グループコード;
    }

    /*
     * gethiddenサンプル文書
     * @return hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public RString getHiddenサンプル文書() {
        return hiddenサンプル文書;
    }

    /*
     * sethiddenサンプル文書
     * @param hiddenサンプル文書 hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public void setHiddenサンプル文書(RString hiddenサンプル文書) {
        this.hiddenサンプル文書 = hiddenサンプル文書;
    }

    /*
     * gethiddenChosaKomokuNo1
     * @return hiddenChosaKomokuNo1
     */
    @JsonProperty("hiddenChosaKomokuNo1")
    public RString getHiddenChosaKomokuNo1() {
        return hiddenChosaKomokuNo1;
    }

    /*
     * sethiddenChosaKomokuNo1
     * @param hiddenChosaKomokuNo1 hiddenChosaKomokuNo1
     */
    @JsonProperty("hiddenChosaKomokuNo1")
    public void setHiddenChosaKomokuNo1(RString hiddenChosaKomokuNo1) {
        this.hiddenChosaKomokuNo1 = hiddenChosaKomokuNo1;
    }

    /*
     * gethiddenChosaKomokuNo2
     * @return hiddenChosaKomokuNo2
     */
    @JsonProperty("hiddenChosaKomokuNo2")
    public RString getHiddenChosaKomokuNo2() {
        return hiddenChosaKomokuNo2;
    }

    /*
     * sethiddenChosaKomokuNo2
     * @param hiddenChosaKomokuNo2 hiddenChosaKomokuNo2
     */
    @JsonProperty("hiddenChosaKomokuNo2")
    public void setHiddenChosaKomokuNo2(RString hiddenChosaKomokuNo2) {
        this.hiddenChosaKomokuNo2 = hiddenChosaKomokuNo2;
    }

    /*
     * gethiddenChosaKomokuNo3
     * @return hiddenChosaKomokuNo3
     */
    @JsonProperty("hiddenChosaKomokuNo3")
    public RString getHiddenChosaKomokuNo3() {
        return hiddenChosaKomokuNo3;
    }

    /*
     * sethiddenChosaKomokuNo3
     * @param hiddenChosaKomokuNo3 hiddenChosaKomokuNo3
     */
    @JsonProperty("hiddenChosaKomokuNo3")
    public void setHiddenChosaKomokuNo3(RString hiddenChosaKomokuNo3) {
        this.hiddenChosaKomokuNo3 = hiddenChosaKomokuNo3;
    }

    /*
     * gethiddenChosaKomokuNo4
     * @return hiddenChosaKomokuNo4
     */
    @JsonProperty("hiddenChosaKomokuNo4")
    public RString getHiddenChosaKomokuNo4() {
        return hiddenChosaKomokuNo4;
    }

    /*
     * sethiddenChosaKomokuNo4
     * @param hiddenChosaKomokuNo4 hiddenChosaKomokuNo4
     */
    @JsonProperty("hiddenChosaKomokuNo4")
    public void setHiddenChosaKomokuNo4(RString hiddenChosaKomokuNo4) {
        this.hiddenChosaKomokuNo4 = hiddenChosaKomokuNo4;
    }

    /*
     * gethiddenChosaKomokuNo5
     * @return hiddenChosaKomokuNo5
     */
    @JsonProperty("hiddenChosaKomokuNo5")
    public RString getHiddenChosaKomokuNo5() {
        return hiddenChosaKomokuNo5;
    }

    /*
     * sethiddenChosaKomokuNo5
     * @param hiddenChosaKomokuNo5 hiddenChosaKomokuNo5
     */
    @JsonProperty("hiddenChosaKomokuNo5")
    public void setHiddenChosaKomokuNo5(RString hiddenChosaKomokuNo5) {
        this.hiddenChosaKomokuNo5 = hiddenChosaKomokuNo5;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtFirstChosaKomokuNo() {
        return this.getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblFirstHyphen() {
        return this.getTblFirstTokkiJiko().getLblFirstHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtFirstTokkiRenban() {
        return this.getTblFirstTokkiJiko().getTxtFirstTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtFirstChosaKomokuMeisho() {
        return this.getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFirstTokkiJiko() {
        return this.getTblFirstTokkiJiko().getTxtFirstTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgFirstTokkiJiko() {
        return this.getTblFirstTokkiJiko().getImgFirstTokkiJiko();
    }

    @JsonIgnore
    public TextBox getTxtSecondChosaKomokuNo() {
        return this.getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblSecondHyphen() {
        return this.getTblSecondTokkiJiko().getLblSecondHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtSecondTokkiRenban() {
        return this.getTblSecondTokkiJiko().getTxtSecondTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtSecondTokkiJikoMeisho() {
        return this.getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtSecondTokkiJiko() {
        return this.getTblSecondTokkiJiko().getTxtSecondTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgSecondTokkiJiko() {
        return this.getTblSecondTokkiJiko().getImgSecondTokkiJiko();
    }

    @JsonIgnore
    public TextBox getTxtThirdChosaKomokuNo() {
        return this.getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblThirdHyphen() {
        return this.getTblThirdTokkiJiko().getLblThirdHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtThirdTokkiRenban() {
        return this.getTblThirdTokkiJiko().getTxtThirdTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtThirdTokkiJikoMeisho() {
        return this.getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtThirdTokkiJiko() {
        return this.getTblThirdTokkiJiko().getTxtThirdTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgThirdTokkiJiko() {
        return this.getTblThirdTokkiJiko().getImgThirdTokkiJiko();
    }

    @JsonIgnore
    public TextBox getTxtFourthChosaKomokuNo() {
        return this.getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblFourthHyphen() {
        return this.getTblFourthTokkiJiko().getLblFourthHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtFourthTokkiRenban() {
        return this.getTblFourthTokkiJiko().getTxtFourthTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtFourthTokkiJikoMeisho() {
        return this.getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFourthTokkiJiko() {
        return this.getTblFourthTokkiJiko().getTxtFourthTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgFourthTokkiJiko() {
        return this.getTblFourthTokkiJiko().getImgFourthTokkiJiko();
    }

    @JsonIgnore
    public TextBox getTxtFifthChosaKomokuNo() {
        return this.getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblFifthHyphen() {
        return this.getTblFifthTokkiJiko().getLblFifthHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtFifthTokkiRenban() {
        return this.getTblFifthTokkiJiko().getTxtFifthTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtFifthTokkiJikoMeisho() {
        return this.getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFifthTokkiJiko() {
        return this.getTblFifthTokkiJiko().getTxtFifthTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgFifthTokkiJiko() {
        return this.getTblFifthTokkiJiko().getImgFifthTokkiJiko();
    }

    // </editor-fold>
}
