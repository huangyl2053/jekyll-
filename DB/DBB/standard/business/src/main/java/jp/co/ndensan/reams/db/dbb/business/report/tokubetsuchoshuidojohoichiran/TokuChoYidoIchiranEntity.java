/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import jp.co.ndensan.reams.db.dbz.business.core.kanri.chohyo.HyojiCodes;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 特徴異動情報Entity クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoYidoIchiranEntity {

    private RString 年金保険者名称;
    private UeT0511NenkinTokuchoKaifuJohoEntity 特徴異動追加情報;
    private EditedAtesaki 編集後宛先;
    private HyojiCodes 表示コード;
}
