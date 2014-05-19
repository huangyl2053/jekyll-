package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DbCommonInfoDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JushochiTokureiTaishosaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JushochiTokureiTaishosaInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaJoho")
    private AtenaShokaiSimpleDiv AtenaJoho;
    @JsonProperty("DbCommonInfo")
    private DbCommonInfoDiv DbCommonInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("AtenaJoho")
    public AtenaShokaiSimpleDiv getAtenaJoho() {
        return AtenaJoho;
    }

    @JsonProperty("AtenaJoho")
    public void setAtenaJoho(AtenaShokaiSimpleDiv AtenaJoho) {
        this.AtenaJoho=AtenaJoho;
    }

    @JsonProperty("DbCommonInfo")
    public DbCommonInfoDiv getDbCommonInfo() {
        return DbCommonInfo;
    }

    @JsonProperty("DbCommonInfo")
    public void setDbCommonInfo(DbCommonInfoDiv DbCommonInfo) {
        this.DbCommonInfo=DbCommonInfo;
    }

}
