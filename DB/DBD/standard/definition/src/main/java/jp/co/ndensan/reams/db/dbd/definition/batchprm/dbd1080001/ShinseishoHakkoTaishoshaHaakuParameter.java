/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1080001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.GemmenGengakuTaishoGaiShaListProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDGM12021_1_減免減額申請書発行用対象者把握(画面)のバッチパラメタークラスです。
 *
 * @reamsid_L DBD-3530-010 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoHakkoTaishoshaHaakuParameter extends BatchParameterBase {

    private RString 新規更新区分;
    private boolean 課税世帯の被保険者を含む;
    private GemmenGengakuShurui 減免減額種類;
    private RString 旧措置区分;
    private RString 施設入所区分;
    private RString 利用者負担段階;
    private boolean 市町村民税非課税世帯;
    private boolean 市町村民税本人非課税者;
    private boolean 老齢福祉年金受給者;
    private boolean 生活保護受給者;
    private FlexibleDate 基準日;
    private FlexibleYear 所得年度;

    /**
     * バーチのパラメータを作成します。
     *
     * @return GemmenGengakuTaishoGaiShaListProcessParameter
     */
    public GemmenGengakuTaishoGaiShaListProcessParameter toGemmenGengakuTaishoGaiShaListProcessParameter() {
        return new GemmenGengakuTaishoGaiShaListProcessParameter(減免減額種類, 基準日);
    }
}
