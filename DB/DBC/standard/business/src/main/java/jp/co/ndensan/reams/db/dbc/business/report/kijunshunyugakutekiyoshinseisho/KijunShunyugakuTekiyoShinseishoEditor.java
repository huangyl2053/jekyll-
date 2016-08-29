/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        if (基準収入額適用申請書Entity.get被保険者生年月日１() != null) {
            source.hihokenshaBirthYMD1 = new RString(基準収入額適用申請書Entity.get被保険者生年月日１().toString());
        }
        source.hihokenshaNo1 = 基準収入額適用申請書Entity.get被保険者番号１();
        source.seibetsu1 = 基準収入額適用申請書Entity.get被保険者性別１();
        source.hihokenshaKanaName2 = 基準収入額適用申請書Entity.get被保険者名カナ２();
        source.hihokenshaName2 = 基準収入額適用申請書Entity.get被保険者氏名２();
        if (基準収入額適用申請書Entity.get被保険者生年月日２() != null) {
            source.hihokenshaBirthYMD2 = new RString(基準収入額適用申請書Entity.get被保険者生年月日２().toString());
        }
        source.hihokenshaNo2 = 基準収入額適用申請書Entity.get被保険者番号２();
        source.seibetsu2 = 基準収入額適用申請書Entity.get被保険者性別２();
        source.hihokenshaKanaName3 = 基準収入額適用申請書Entity.get被保険者名カナ３();
        source.hihokenshaName3 = 基準収入額適用申請書Entity.get被保険者氏名３();
        if (基準収入額適用申請書Entity.get被保険者生年月日３() != null) {
            source.hihokenshaBirthYMD3 = new RString(基準収入額適用申請書Entity.get被保険者生年月日３().toString());
        }
        source.hihokenshaNo3 = 基準収入額適用申請書Entity.get被保険者番号３();
        source.seibetsu3 = 基準収入額適用申請書Entity.get被保険者性別３();
        source.jusho1 = 基準収入額適用申請書Entity.get住所１();
        source.jusho2 = 基準収入額適用申請書Entity.get住所２();
        source.renrakusaki = 基準収入額適用申請書Entity.get連絡先();
        source.shunyuGengo = 基準収入額適用申請書Entity.get収入元号();
        source.shunyuNen = 基準収入額適用申請書Entity.get収入年();
        source.tsuchibun1 = 基準収入額適用申請書Entity.get通知文１();
        source.tsuchibun2 = 基準収入額適用申請書Entity.get通知文２();
        source.tsuchibun3 = 基準収入額適用申請書Entity.get通知文３();
        source.tsuchibun4 = 基準収入額適用申請書Entity.get通知文4();
        source.tsuchibun5 = 基準収入額適用申請書Entity.get通知文5();
        source.tsuchibun6 = 基準収入額適用申請書Entity.get通知文6();
        source.tsuchibun7 = 基準収入額適用申請書Entity.get通知文7();
        source.tsuchibun8 = 基準収入額適用申請書Entity.get通知文８();
        source.tsuchibun9 = 基準収入額適用申請書Entity.get通知文９();
        source.tsuchibun10 = 基準収入額適用申請書Entity.get通知文１０();
        source.tsuchibun11 = 基準収入額適用申請書Entity.get通知文１１();
        source.tsuchibun12 = 基準収入額適用申請書Entity.get通知文１２();
        source.tsuchibun13 = 基準収入額適用申請書Entity.get通知文１３();

        if (基準収入額適用申請書Entity.get識別コード１() != null) {
            source.shikibetsuCode1 = 基準収入額適用申請書Entity.get識別コード１().value();
        }
        if (基準収入額適用申請書Entity.get識別コード２() != null) {
            source.shikibetsuCode2 = 基準収入額適用申請書Entity.get識別コード２().value();
        }
        if (基準収入額適用申請書Entity.get識別コード３() != null) {
            source.shikibetsuCode3 = 基準収入額適用申請書Entity.get識別コード３().value();
        }

        return source;
    }

}
