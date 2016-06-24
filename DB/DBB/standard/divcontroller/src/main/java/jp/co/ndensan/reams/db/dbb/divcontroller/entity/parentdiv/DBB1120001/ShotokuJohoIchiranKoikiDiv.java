package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuJohoIchiranKoiki のクラスファイル
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoIchiranKoikiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChohyoShutsuryokujunKoiki")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujunKoiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdChohyoShutsuryokujunKoiki
     * @return ccdChohyoShutsuryokujunKoiki
     */
    @JsonProperty("ccdChohyoShutsuryokujunKoiki")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujunKoiki() {
        return ccdChohyoShutsuryokujunKoiki;
    }

    // </editor-fold>
}
