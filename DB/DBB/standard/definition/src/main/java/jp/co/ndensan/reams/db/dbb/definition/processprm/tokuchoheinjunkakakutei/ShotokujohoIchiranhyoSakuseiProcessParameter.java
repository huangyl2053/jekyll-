/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51003_所得情報一覧表作成のParameter
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokujohoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private RString 導入形態コード;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private FlexibleYear 処理年度;
    private RString チェックボックス;
    private RString ラジオボタン;
    private YMDHMS 開始日時;
    private YMDHMS 終了日時;
    private List<ShichosonJouhouResult> 市町村情報リスト;
    private Long 出力順ID;
    private RString 出力順;
    private RString 改頁;

    /**
     * コンストラクタです。
     *
     * @param 導入形態コード RString
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 処理年度 FlexibleYear
     * @param チェックボックス RString
     * @param ラジオボタン RString
     * @param 開始日時 YMDHMS
     * @param 終了日時 YMDHMS
     * @param 市町村情報リスト List<ShichosonJouhouResult>
     * @param 出力順ID RString
     * @param 出力順 RString
     * @param 改頁 RString
     */
    public ShotokujohoIchiranhyoSakuseiProcessParameter(RString 導入形態コード,
            LasdecCode 市町村コード,
            RString 市町村名称,
            FlexibleYear 処理年度,
            RString チェックボックス,
            RString ラジオボタン,
            YMDHMS 開始日時,
            YMDHMS 終了日時,
            List<ShichosonJouhouResult> 市町村情報リスト,
            Long 出力順ID,
            RString 出力順,
            RString 改頁) {
        this.導入形態コード = 導入形態コード;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.処理年度 = 処理年度;
        this.チェックボックス = チェックボックス;
        this.ラジオボタン = ラジオボタン;
        this.開始日時 = 開始日時;
        this.終了日時 = 終了日時;
        this.市町村情報リスト = 市町村情報リスト;
        this.出力順ID = 出力順ID;
        this.出力順 = 出力順;
        this.改頁 = 改頁;
    }
}
