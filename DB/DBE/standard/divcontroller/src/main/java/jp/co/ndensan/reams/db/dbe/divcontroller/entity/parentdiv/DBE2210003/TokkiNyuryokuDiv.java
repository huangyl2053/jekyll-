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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
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
    @JsonProperty("hdnTextMasking")
    private RString hdnTextMasking;
    @JsonProperty("hiddenFirstTokkiJiko")
    private RString hiddenFirstTokkiJiko;
    @JsonProperty("hiddenSecondTokkiJiko")
    private RString hiddenSecondTokkiJiko;
    @JsonProperty("hiddenThirdTokkiJiko")
    private RString hiddenThirdTokkiJiko;
    @JsonProperty("hiddenFourthTokkiJiko")
    private RString hiddenFourthTokkiJiko;
    @JsonProperty("hiddenFifthTokkiJiko")
    private RString hiddenFifthTokkiJiko;
    @JsonProperty("hiddenGaikyoTokkiNyurokuMap_MASK")
    private RString hiddenGaikyoTokkiNyurokuMap_MASK;
    @JsonProperty("hiddenOriginalGaikyoTokkiNyurokuMap")
    private RString hiddenOriginalGaikyoTokkiNyurokuMap;
    @JsonProperty("hiddenOriginalGaikyoTokkiNyurokuMap_MASK")
    private RString hiddenOriginalGaikyoTokkiNyurokuMap_MASK;

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
     * gethdnTextMasking
     * @return hdnTextMasking
     */
    @JsonProperty("hdnTextMasking")
    public RString getHdnTextMasking() {
        return hdnTextMasking;
    }

    /*
     * sethdnTextMasking
     * @param hdnTextMasking hdnTextMasking
     */
    @JsonProperty("hdnTextMasking")
    public void setHdnTextMasking(RString hdnTextMasking) {
        this.hdnTextMasking = hdnTextMasking;
    }

    /*
     * gethiddenFirstTokkiJiko
     * @return hiddenFirstTokkiJiko
     */
    @JsonProperty("hiddenFirstTokkiJiko")
    public RString getHiddenFirstTokkiJiko() {
        return hiddenFirstTokkiJiko;
    }

    /*
     * sethiddenFirstTokkiJiko
     * @param hiddenFirstTokkiJiko hiddenFirstTokkiJiko
     */
    @JsonProperty("hiddenFirstTokkiJiko")
    public void setHiddenFirstTokkiJiko(RString hiddenFirstTokkiJiko) {
        this.hiddenFirstTokkiJiko = hiddenFirstTokkiJiko;
    }

    /*
     * gethiddenSecondTokkiJiko
     * @return hiddenSecondTokkiJiko
     */
    @JsonProperty("hiddenSecondTokkiJiko")
    public RString getHiddenSecondTokkiJiko() {
        return hiddenSecondTokkiJiko;
    }

    /*
     * sethiddenSecondTokkiJiko
     * @param hiddenSecondTokkiJiko hiddenSecondTokkiJiko
     */
    @JsonProperty("hiddenSecondTokkiJiko")
    public void setHiddenSecondTokkiJiko(RString hiddenSecondTokkiJiko) {
        this.hiddenSecondTokkiJiko = hiddenSecondTokkiJiko;
    }

    /*
     * gethiddenThirdTokkiJiko
     * @return hiddenThirdTokkiJiko
     */
    @JsonProperty("hiddenThirdTokkiJiko")
    public RString getHiddenThirdTokkiJiko() {
        return hiddenThirdTokkiJiko;
    }

    /*
     * sethiddenThirdTokkiJiko
     * @param hiddenThirdTokkiJiko hiddenThirdTokkiJiko
     */
    @JsonProperty("hiddenThirdTokkiJiko")
    public void setHiddenThirdTokkiJiko(RString hiddenThirdTokkiJiko) {
        this.hiddenThirdTokkiJiko = hiddenThirdTokkiJiko;
    }

    /*
     * gethiddenFourthTokkiJiko
     * @return hiddenFourthTokkiJiko
     */
    @JsonProperty("hiddenFourthTokkiJiko")
    public RString getHiddenFourthTokkiJiko() {
        return hiddenFourthTokkiJiko;
    }

    /*
     * sethiddenFourthTokkiJiko
     * @param hiddenFourthTokkiJiko hiddenFourthTokkiJiko
     */
    @JsonProperty("hiddenFourthTokkiJiko")
    public void setHiddenFourthTokkiJiko(RString hiddenFourthTokkiJiko) {
        this.hiddenFourthTokkiJiko = hiddenFourthTokkiJiko;
    }

    /*
     * gethiddenFifthTokkiJiko
     * @return hiddenFifthTokkiJiko
     */
    @JsonProperty("hiddenFifthTokkiJiko")
    public RString getHiddenFifthTokkiJiko() {
        return hiddenFifthTokkiJiko;
    }

    /*
     * sethiddenFifthTokkiJiko
     * @param hiddenFifthTokkiJiko hiddenFifthTokkiJiko
     */
    @JsonProperty("hiddenFifthTokkiJiko")
    public void setHiddenFifthTokkiJiko(RString hiddenFifthTokkiJiko) {
        this.hiddenFifthTokkiJiko = hiddenFifthTokkiJiko;
    }

    /*
     * gethiddenGaikyoTokkiNyurokuMap_MASK
     * @return hiddenGaikyoTokkiNyurokuMap_MASK
     */
    @JsonProperty("hiddenGaikyoTokkiNyurokuMap_MASK")
    public RString getHiddenGaikyoTokkiNyurokuMap_MASK() {
        return hiddenGaikyoTokkiNyurokuMap_MASK;
    }

    /*
     * sethiddenGaikyoTokkiNyurokuMap_MASK
     * @param hiddenGaikyoTokkiNyurokuMap_MASK hiddenGaikyoTokkiNyurokuMap_MASK
     */
    @JsonProperty("hiddenGaikyoTokkiNyurokuMap_MASK")
    public void setHiddenGaikyoTokkiNyurokuMap_MASK(RString hiddenGaikyoTokkiNyurokuMap_MASK) {
        this.hiddenGaikyoTokkiNyurokuMap_MASK = hiddenGaikyoTokkiNyurokuMap_MASK;
    }

    /*
     * gethiddenOriginalGaikyoTokkiNyurokuMap
     * @return hiddenOriginalGaikyoTokkiNyurokuMap
     */
    @JsonProperty("hiddenOriginalGaikyoTokkiNyurokuMap")
    public RString getHiddenOriginalGaikyoTokkiNyurokuMap() {
        return hiddenOriginalGaikyoTokkiNyurokuMap;
    }

    /*
     * sethiddenOriginalGaikyoTokkiNyurokuMap
     * @param hiddenOriginalGaikyoTokkiNyurokuMap hiddenOriginalGaikyoTokkiNyurokuMap
     */
    @JsonProperty("hiddenOriginalGaikyoTokkiNyurokuMap")
    public void setHiddenOriginalGaikyoTokkiNyurokuMap(RString hiddenOriginalGaikyoTokkiNyurokuMap) {
        this.hiddenOriginalGaikyoTokkiNyurokuMap = hiddenOriginalGaikyoTokkiNyurokuMap;
    }

    /*
     * gethiddenOriginalGaikyoTokkiNyurokuMap_MASK
     * @return hiddenOriginalGaikyoTokkiNyurokuMap_MASK
     */
    @JsonProperty("hiddenOriginalGaikyoTokkiNyurokuMap_MASK")
    public RString getHiddenOriginalGaikyoTokkiNyurokuMap_MASK() {
        return hiddenOriginalGaikyoTokkiNyurokuMap_MASK;
    }

    /*
     * sethiddenOriginalGaikyoTokkiNyurokuMap_MASK
     * @param hiddenOriginalGaikyoTokkiNyurokuMap_MASK hiddenOriginalGaikyoTokkiNyurokuMap_MASK
     */
    @JsonProperty("hiddenOriginalGaikyoTokkiNyurokuMap_MASK")
    public void setHiddenOriginalGaikyoTokkiNyurokuMap_MASK(RString hiddenOriginalGaikyoTokkiNyurokuMap_MASK) {
        this.hiddenOriginalGaikyoTokkiNyurokuMap_MASK = hiddenOriginalGaikyoTokkiNyurokuMap_MASK;
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
