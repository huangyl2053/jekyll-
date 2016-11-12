/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 帳票設計_DBC100064_基準収入額適用申請書 Editorクラスです。
 *
 * @reamsid_L DBC-4640-040 lijian
 */
public class KijunShunyugakuTekiyoShinseishoEditor implements IKijunShunyugakuTekiyoShinseishoEditor {

    private final KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity;

    /**
     * コンストラクタです。
     *
     * @param 基準収入額適用申請書Entity KijunShunyugakuTekiyoShinseishoEntity
     */
    public KijunShunyugakuTekiyoShinseishoEditor(KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity) {
        this.基準収入額適用申請書Entity = 基準収入額適用申請書Entity;
    }

    @Override
    public KijunShunyugakuTekiyoShinseishoSource edit(KijunShunyugakuTekiyoShinseishoSource source) {

        source.shinsenSakiDaihyo = 基準収入額適用申請書Entity.get申請先();
        source.hihokenshaKanaName1 = 基準収入額適用申請書Entity.get被保険者名カナ１();
        source.hihokenshaName1 = 基準収入額適用申請書Entity.get被保険者氏名１();
        source.hihokenshaBirthYMD1 = doパターン12(基準収入額適用申請書Entity.get被保険者生年月日１());
        source.hihokenshaNo1 = 基準収入額適用申請書Entity.get被保険者番号１();
        source.seibetsu1 = 基準収入額適用申請書Entity.get被保険者性別１();
        source.hihokenshaKanaName2 = 基準収入額適用申請書Entity.get被保険者名カナ２();
        source.hihokenshaName2 = 基準収入額適用申請書Entity.get被保険者氏名２();
        source.hihokenshaBirthYMD2 = doパターン12(基準収入額適用申請書Entity.get被保険者生年月日２());
        source.hihokenshaNo2 = 基準収入額適用申請書Entity.get被保険者番号２();
        source.seibetsu2 = 基準収入額適用申請書Entity.get被保険者性別２();
        source.hihokenshaKanaName3 = 基準収入額適用申請書Entity.get被保険者名カナ３();
        source.hihokenshaName3 = 基準収入額適用申請書Entity.get被保険者氏名３();
        source.hihokenshaBirthYMD3 = doパターン12(基準収入額適用申請書Entity.get被保険者生年月日３());
        source.hihokenshaNo3 = 基準収入額適用申請書Entity.get被保険者番号３();
        source.seibetsu3 = 基準収入額適用申請書Entity.get被保険者性別３();
        source.jusho1 = 基準収入額適用申請書Entity.get住所１();
        source.jusho2 = 基準収入額適用申請書Entity.get住所２();
        source.jusho = 基準収入額適用申請書Entity.get住所１();
        if (null != 基準収入額適用申請書Entity.get住所２()) {
            source.jusho = source.jusho.concat(基準収入額適用申請書Entity.get住所２());
        }
        source.renrakusaki = 基準収入額適用申請書Entity.get連絡先();
        source.shunyuGengo = 基準収入額適用申請書Entity.get収入元号();
        source.shunyuNen = 基準収入額適用申請書Entity.get収入年();
        source.tsuchibun1 = 基準収入額適用申請書Entity.get通知文１();

        if (基準収入額適用申請書Entity.get識別コード１() != null) {
            source.shikibetsuCode1 = 基準収入額適用申請書Entity.get識別コード１().value();
        }
        if (基準収入額適用申請書Entity.get識別コード２() != null) {
            source.shikibetsuCode2 = 基準収入額適用申請書Entity.get識別コード２().value();
        }
        if (基準収入額適用申請書Entity.get識別コード３() != null) {
            source.shikibetsuCode3 = 基準収入額適用申請書Entity.get識別コード３().value();
        }
        source.拡張情報A1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo1));
        source.拡張情報A2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), get非空文字列(source.hihokenshaName1));
        source.拡張情報B1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo2));
        source.拡張情報B2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), get非空文字列(source.hihokenshaName2));
        source.拡張情報C1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo3));
        source.拡張情報C2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), get非空文字列(source.hihokenshaName3));
        return source;
    }

    private RString doパターン12(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
