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
    private ShichosonJouhouResult 市町村情報;
    private Long 出力順ID;
    private RString 出力順;
    private RString 改頁;

}
