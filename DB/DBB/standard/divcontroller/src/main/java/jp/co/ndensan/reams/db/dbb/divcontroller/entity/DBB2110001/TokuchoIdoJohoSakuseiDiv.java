package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB2110001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB2110001.TokuchoIdoJohoSaiSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB2110001.tbldgTokuchoIdoJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokuchoIdoJohoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoIdoJohoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbldgTokuchoIdoJoho")
    private tbldgTokuchoIdoJohoDiv tbldgTokuchoIdoJoho;
    @JsonProperty("TokuchoIdoJohoSaiSakusei")
    private TokuchoIdoJohoSaiSakuseiDiv TokuchoIdoJohoSaiSakusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tbldgTokuchoIdoJoho")
    public tbldgTokuchoIdoJohoDiv getTbldgTokuchoIdoJoho() {
        return tbldgTokuchoIdoJoho;
    }

    @JsonProperty("tbldgTokuchoIdoJoho")
    public void setTbldgTokuchoIdoJoho(tbldgTokuchoIdoJohoDiv tbldgTokuchoIdoJoho) {
        this.tbldgTokuchoIdoJoho=tbldgTokuchoIdoJoho;
    }

    @JsonProperty("TokuchoIdoJohoSaiSakusei")
    public TokuchoIdoJohoSaiSakuseiDiv getTokuchoIdoJohoSaiSakusei() {
        return TokuchoIdoJohoSaiSakusei;
    }

    @JsonProperty("TokuchoIdoJohoSaiSakusei")
    public void setTokuchoIdoJohoSaiSakusei(TokuchoIdoJohoSaiSakuseiDiv TokuchoIdoJohoSaiSakusei) {
        this.TokuchoIdoJohoSaiSakusei=TokuchoIdoJohoSaiSakusei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTsuki() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki();
    }

    @JsonIgnore
    public Label getLblShoriNichiji() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji();
    }

    @JsonIgnore
    public Label getLblTsuchiNaiyo() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuchiNaiyo();
    }

    @JsonIgnore
    public Label getLblShikakuSoshitsu() {
        return this.getTbldgTokuchoIdoJoho().getLblShikakuSoshitsu();
    }

    @JsonIgnore
    public Label getLblJutokuGaito() {
        return this.getTbldgTokuchoIdoJoho().getLblJutokuGaito();
    }

    @JsonIgnore
    public Label getLblKariHenko() {
        return this.getTbldgTokuchoIdoJoho().getLblKariHenko();
    }

    @JsonIgnore
    public Label getLblTokuchotsuikaIrai() {
        return this.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku04() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku04();
    }

    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblShoriNichiji04() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji04();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu04() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu04();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito04() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito04();
    }

    @JsonIgnore
    public Icon getIcoKariHenko04() {
        return this.getTbldgTokuchoIdoJoho().getIcoKariHenko04();
    }

    @JsonIgnore
    public Icon getIcoTokuchotsuikaIrai04() {
        return this.getTbldgTokuchoIdoJoho().getIcoTokuchotsuikaIrai04();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku05() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku05();
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblShoriNichiji05() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji05();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu05() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu05();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito05() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito05();
    }

    @JsonIgnore
    public Icon getIcoKariHenko05() {
        return this.getTbldgTokuchoIdoJoho().getIcoKariHenko05();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku06() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku06();
    }

    @JsonIgnore
    public Label getLblTsuki3() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki3();
    }

    @JsonIgnore
    public Label getLblShoriNichiji06() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji06();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu06() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu06();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito06() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito06();
    }

    @JsonIgnore
    public Icon getIcoKariHenko06() {
        return this.getTbldgTokuchoIdoJoho().getIcoKariHenko06();
    }

    @JsonIgnore
    public Icon getIcoTokuchotsuikaIrai06() {
        return this.getTbldgTokuchoIdoJoho().getIcoTokuchotsuikaIrai06();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku07() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku07();
    }

    @JsonIgnore
    public Label getLblTsuki4() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki4();
    }

    @JsonIgnore
    public Label getLblShoriNichiji07() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji07();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu07() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu07();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito07() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito07();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku08() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku08();
    }

    @JsonIgnore
    public Label getLblTsuki5() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki5();
    }

    @JsonIgnore
    public Label getLblShoriNichiji08() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji08();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu08() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu08();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito08() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito08();
    }

    @JsonIgnore
    public Icon getIcoTokuchotsuikaIrai08() {
        return this.getTbldgTokuchoIdoJoho().getIcoTokuchotsuikaIrai08();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku09() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku09();
    }

    @JsonIgnore
    public Label getLblTsuki6() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki6();
    }

    @JsonIgnore
    public Label getLblShoriNichiji09() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji09();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu09() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu09();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito09() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito09();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku10() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku10();
    }

    @JsonIgnore
    public Label getLblTsuki7() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki7();
    }

    @JsonIgnore
    public Label getLblShoriNichiji10() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji10();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu10() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu10();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito10() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito10();
    }

    @JsonIgnore
    public Icon getIcoTokuchotsuikaIrai10() {
        return this.getTbldgTokuchoIdoJoho().getIcoTokuchotsuikaIrai10();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku11() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku11();
    }

    @JsonIgnore
    public Label getLblTsuki8() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki8();
    }

    @JsonIgnore
    public Label getLblShoriNichiji11() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji11();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu11() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu11();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito11() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito11();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku12() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku12();
    }

    @JsonIgnore
    public Label getLblTsuki9() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki9();
    }

    @JsonIgnore
    public Label getLblShoriNichiji12() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji12();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu12() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu12();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito12() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito12();
    }

    @JsonIgnore
    public Icon getIcoTokuchotsuikaIrai12() {
        return this.getTbldgTokuchoIdoJoho().getIcoTokuchotsuikaIrai12();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku01() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku01();
    }

    @JsonIgnore
    public Label getLblTsuki10() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki10();
    }

    @JsonIgnore
    public Label getLblShoriNichiji01() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji01();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu01() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu01();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito01() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito01();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku02() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku02();
    }

    @JsonIgnore
    public Label getLblTsuki11() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki11();
    }

    @JsonIgnore
    public Label getLblShoriNichiji02() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji02();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu02() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu02();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito02() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito02();
    }

    @JsonIgnore
    public Icon getIcoTokuchotsuikaIrai02() {
        return this.getTbldgTokuchoIdoJoho().getIcoTokuchotsuikaIrai02();
    }

    @JsonIgnore
    public CheckBoxList getChkSentaku03() {
        return this.getTbldgTokuchoIdoJoho().getChkSentaku03();
    }

    @JsonIgnore
    public Label getLblTsuki12() {
        return this.getTbldgTokuchoIdoJoho().getLblTsuki12();
    }

    @JsonIgnore
    public Label getLblShoriNichiji03() {
        return this.getTbldgTokuchoIdoJoho().getLblShoriNichiji03();
    }

    @JsonIgnore
    public Icon getIcoShikakuSoshitsu03() {
        return this.getTbldgTokuchoIdoJoho().getIcoShikakuSoshitsu03();
    }

    @JsonIgnore
    public Icon getIcoJutokuGaito03() {
        return this.getTbldgTokuchoIdoJoho().getIcoJutokuGaito03();
    }

}
