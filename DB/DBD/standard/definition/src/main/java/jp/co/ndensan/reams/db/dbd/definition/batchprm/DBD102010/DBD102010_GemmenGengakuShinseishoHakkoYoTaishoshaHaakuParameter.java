/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD102010;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.GemmenGengakuTaishoGaiShaListProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
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
public class DBD102010_GemmenGengakuShinseishoHakkoYoTaishoshaHaakuParameter extends BatchParameterBase {

    private static final String SINKINKOUSINKUBUN = "sinkinkousinkubun";
    private static final String KAZEISEITAINONIHOKENSHAWOAMU = "kazeiseitainohihokenshawoamu";
    private static final String GENMENGENKAXYOLAI = "genmengenkaxyolai";
    private static final String SOTONENDO = "sotonendo";
    private static final String KYUSOTIKUBUN = "kyusotikubun";
    private static final String SHISETSUNYUSHOKUBUN = "shisetsunyushokubun";
    private static final String LIYOSHAFUTANGDANKAI = "liyoshafutangdankai";
    private static final String CHICHOUSONMINHIKAZEISEITAI = "chichousonminhikazeiseitai";
    private static final String CHICHOUSONMINHONNIHIKAZEISEITAI = "chichousonminhonnihikazeiseitai";
    private static final String RAOREIFUKUSHINENKINSHOUGAISHA = "raoreifukushinenkinshougaisha";
    private static final String SEIKATSUHOGOSHOUGAISHA = "seigatsuhogoshougaisha";
    private static final String KIJUNHI = "kijunhi";

    @BatchParameter(key = SINKINKOUSINKUBUN, name = "新規更新区分")
    private RString 新規更新区分;
    @BatchParameter(key = KAZEISEITAINONIHOKENSHAWOAMU, name = "課税世帯の被保険者を含む")
    private boolean 課税世帯の被保険者を含む;
    @BatchParameter(key = GENMENGENKAXYOLAI, name = "減免減額種類")
    private GemmenGengakuShurui 減免減額種類;
    @BatchParameter(key = KYUSOTIKUBUN, name = "旧措置区分")
    private RString 旧措置区分;
    @BatchParameter(key = SHISETSUNYUSHOKUBUN, name = "施設入所区分")
    private RString 施設入所区分;
    @BatchParameter(key = LIYOSHAFUTANGDANKAI, name = "利用者負担段階")
    private RString 利用者負担段階;
    @BatchParameter(key = CHICHOUSONMINHIKAZEISEITAI, name = "市町村民税非課税世帯")
    private boolean 市町村民税非課税世帯;
    @BatchParameter(key = CHICHOUSONMINHONNIHIKAZEISEITAI, name = "市町村民税本人非課税者")
    private boolean 市町村民税本人非課税者;
    @BatchParameter(key = RAOREIFUKUSHINENKINSHOUGAISHA, name = "老齢福祉年金受給者")
    private boolean 老齢福祉年金受給者;
    @BatchParameter(key = SEIKATSUHOGOSHOUGAISHA, name = "生活保護受給者")
    private boolean 生活保護受給者;
    @BatchParameter(key = KIJUNHI, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = SOTONENDO, name = "所得年度")
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
