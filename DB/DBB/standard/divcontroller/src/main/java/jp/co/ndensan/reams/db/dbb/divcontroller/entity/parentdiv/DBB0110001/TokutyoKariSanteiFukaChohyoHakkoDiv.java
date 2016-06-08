package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.IOutputChohyoIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.OutputChohyoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokutyoKariSanteiFukaChohyoHakko のクラスファイル
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokutyoKariSanteiFukaChohyoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokutyoKariTsuchiKobetsuJoho")
    private TokutyoKariTsuchiKobetsuJohoDiv TokutyoKariTsuchiKobetsuJoho;
    @JsonProperty("ccdChohyoIchiran")
    private OutputChohyoIchiranDiv ccdChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokutyoKariTsuchiKobetsuJoho
     * @return TokutyoKariTsuchiKobetsuJoho
     */
    @JsonProperty("TokutyoKariTsuchiKobetsuJoho")
    public TokutyoKariTsuchiKobetsuJohoDiv getTokutyoKariTsuchiKobetsuJoho() {
        return TokutyoKariTsuchiKobetsuJoho;
    }

    /*
     * setTokutyoKariTsuchiKobetsuJoho
     * @param TokutyoKariTsuchiKobetsuJoho TokutyoKariTsuchiKobetsuJoho
     */
    @JsonProperty("TokutyoKariTsuchiKobetsuJoho")
    public void setTokutyoKariTsuchiKobetsuJoho(TokutyoKariTsuchiKobetsuJohoDiv TokutyoKariTsuchiKobetsuJoho) {
        this.TokutyoKariTsuchiKobetsuJoho = TokutyoKariTsuchiKobetsuJoho;
    }

    /*
     * getccdChohyoIchiran
     * @return ccdChohyoIchiran
     */
    @JsonProperty("ccdChohyoIchiran")
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return ccdChohyoIchiran;
    }

    // </editor-fold>
}
