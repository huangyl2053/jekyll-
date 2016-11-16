/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.honnsanteifuka;

import jp.co.ndensan.reams.db.dbc.entity.csv.kunihosorensofudata.KuniHoSorenSofuDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200095.KokuhorenSofuDataErrorIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.SofuEraRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理前共同処理用受給者の作成クラスです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
@Getter
@Setter
public class KyodoShoriKihonSofuBusiness {

    /**
     * コンストラクタです。
     *
     */
    public KyodoShoriKihonSofuBusiness() {
    }

    /**
     * 共同処理基本送付全件一時Bを設定します。
     *
     * @param entity 共同処理用受給者異動基本送付
     * @return 共同処理基本送付全件一時
     */
    public KyodoShoriKihonSofuTempEntity set共同処理基本送付全件(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity) {
        KyodoShoriKihonSofuTempEntity tableEntity = new KyodoShoriKihonSofuTempEntity();
        tableEntity.set異動年月日(entity.getIdoYMD());
        tableEntity.set異動区分コード(entity.getIdoKubunCode());
        tableEntity.set受給者異動事由(entity.getJukyushaIdoJiyu());
        tableEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        tableEntity.set被保険者番号(entity.getHiHokenshaNo());
        tableEntity.set履歴番号(entity.getRirekiNo());
        tableEntity.set被保険者氏名(entity.getHiHokenshaName());
        tableEntity.set郵便番号(entity.getYubinNo());
        tableEntity.set住所カナ(entity.getDdressKana());
        tableEntity.set住所(entity.getAddress());
        tableEntity.set電話番号(entity.getTelNo());
        tableEntity.set帳票出力順序コード(entity.getChohyoOutputJunjyoCode());
        tableEntity.set訂正連絡票フラグ(entity.getTeiseiRenrakuhyoFlag());
        tableEntity.set送付年月(entity.getSofuYM());
        tableEntity.set訂正区分コード(entity.getTeiseiKubunCode());
        tableEntity.set訂正年月日(entity.getTeiseiYMD());
        tableEntity.set論理削除フラグ(entity.getLogicalDeletedFlag());
        return tableEntity;
    }

    /**
     * 共同処理償還送付全件一時Bを設定します。
     *
     * @param entity 共同処理用受給者異動償還送付
     * @return 共同処理償還送付全件一時
     */
    public KyodoShoriShouKannTempEntity set共同処理償還送付全件(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        KyodoShoriShouKannTempEntity tableEntity = new KyodoShoriShouKannTempEntity();
        tableEntity.set異動年月日(entity.getIdoYMD());
        tableEntity.set異動区分コード(entity.getIdoKubunCode());
        tableEntity.set受給者異動事由(entity.getJukyushaIdoJiyu());
        tableEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        tableEntity.set被保険者番号(entity.getHiHokenshaNo());
        tableEntity.set履歴番号(entity.getRirekiNo());
        tableEntity.set保険給付支払一時差止開始年月日(entity.getHokenKyufuIchijiSashitomeKaishiYMD());
        tableEntity.set保険給付支払一時差止終了年月日(entity.getHokenKyufuIchijiSashitomeShuryoYMD());
        tableEntity.set保険給付支払一時差止区分コード(entity.getHokenkyufuIchijiSashitomeKubunCode());
        tableEntity.set保険給付支払一時差止金額(entity.getHokenkyufuIchijiSashitomeKingaku());
        tableEntity.set訂正連絡票フラグ(entity.getTeiseiRenrakuhyoFlag());
        tableEntity.set送付年月(entity.getSofuYM());
        tableEntity.set訂正区分コード(entity.getTeiseiKubunCode());
        tableEntity.set訂正年月日(entity.getTeiseiYMD());
        tableEntity.set論理削除フラグ(entity.getLogicalDeletedFlag());
        return tableEntity;
    }

    /**
     * 共同処理基本高額全件一時Bを設定します。
     *
     * @param entity 共同処理用受給者異動高額送付
     * @return 共同処理高額送付全件一時
     */
    public KyodoShoriKooGakuTempEntity set共同処理高額送付全件(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity) {
        KyodoShoriKooGakuTempEntity tableEntity = new KyodoShoriKooGakuTempEntity();
        tableEntity.set異動年月日(entity.getIdoYMD());
        tableEntity.set異動区分コード(entity.getIdoKubunCode());
        tableEntity.set受給者異動事由(entity.getJukyushaIdoJiyu());
        tableEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        tableEntity.set被保険者番号(entity.getHiHokenshaNo());
        tableEntity.set履歴番号(entity.getRirekiNo());
        tableEntity.set世帯集約番号(entity.getSetaiShuyakuNo());
        tableEntity.set世帯所得区分コード(entity.getSetaiShotokuKubunCode());
        tableEntity.set所得区分コード(entity.getShotokuKubunCode());
        tableEntity.set老齢福祉年金受給有フラグ(entity.getRoureiFukushiNenkinJukyuAriFlag());
        tableEntity.set利用者負担第２段階有フラグ(entity.getRiyoshaFutan2DankaiAriFlag());
        tableEntity.set支給申請書出力有フラグ(entity.getShikyuShinseishoOutputAriFlag());
        tableEntity.set訂正連絡票フラグ(entity.getTeiseiRenrakuhyoFlag());
        tableEntity.set送付年月(entity.getSofuYM());
        tableEntity.set訂正区分コード(entity.getTeiseiKubunCode());
        tableEntity.set訂正年月日(entity.getTeiseiYMD());
        tableEntity.set論理削除フラグ(entity.getLogicalDeletedFlag());
        return tableEntity;
    }

    /**
     * 国保連送付データエラーリストのEntityを取得します。
     *
     * @param entity SofuEraRelateEntity
     * @param 処理年月 処理年月
     *
     * @return 帳票Entity
     */
    public KokuhorenSofuDataErrorIchiranEntity set帳票出力対象データ(SofuEraRelateEntity entity, RString 処理年月) {
        KokuhorenSofuDataErrorIchiranEntity kokuhorenSofuDatEntity = new KokuhorenSofuDataErrorIchiranEntity();
        kokuhorenSofuDatEntity.set被保険者番号(entity.get被保険者番号());
        kokuhorenSofuDatEntity.set氏名カナ(entity.get氏名カナ());
        kokuhorenSofuDatEntity.set氏名(entity.get氏名());
        kokuhorenSofuDatEntity.set資格取得日(entity.get資格取得日());
        kokuhorenSofuDatEntity.set認定要介護度(entity.get要介護状態区分コード().value());
        kokuhorenSofuDatEntity.set認定申請日(entity.get要介護認定申請日());
        kokuhorenSofuDatEntity.set居宅事業者番号(entity.get居宅事業者番号().value());
        kokuhorenSofuDatEntity.set特定申請日(entity.get特定申請日());
        kokuhorenSofuDatEntity.set特定開始日(entity.get特定適用開始日());
        kokuhorenSofuDatEntity.set特定終了日(entity.get特定適用終了日());
        kokuhorenSofuDatEntity.set社福開始日(entity.get社会福祉適用開始日());
        kokuhorenSofuDatEntity.set社福終了日(entity.get社会福祉適用終了日());
        kokuhorenSofuDatEntity.set償還開始日(entity.get償還払化開始日());
        kokuhorenSofuDatEntity.setエラー情報コード(entity.getエラーコード());
        kokuhorenSofuDatEntity.setエラー情報内容(entity.getエラー内容());
        kokuhorenSofuDatEntity.set資格喪失日(entity.get資格喪失日());
        kokuhorenSofuDatEntity.set認定開始日(entity.get認定開始日());
        kokuhorenSofuDatEntity.set認定終了日(entity.get認定終了日());
        kokuhorenSofuDatEntity.set居宅開始日(entity.get居宅適用開始日());
        kokuhorenSofuDatEntity.set利用申請日(entity.get利用者負担申請日());
        kokuhorenSofuDatEntity.set利用開始日(entity.get利用者負担適用開始日());
        kokuhorenSofuDatEntity.set利用終了日(entity.get利用者負担適用終了日());
        kokuhorenSofuDatEntity.set標準開始日(entity.get標準負担適用開始日());
        kokuhorenSofuDatEntity.set標準終了日(entity.get標準負担適用終了日());
        kokuhorenSofuDatEntity.set引下開始日(entity.get給付率引下げ開始日());
        kokuhorenSofuDatEntity.set作成年月日(FlexibleDate.getNowDate());
        kokuhorenSofuDatEntity.set処理年月(new FlexibleYearMonth(処理年月));
        return kokuhorenSofuDatEntity;
    }

    /**
     * 国保連送付データエラーリストCSVを取得します。
     *
     * @param entity SofuEraRelateEntity
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 連番 連番
     * @param 処理年月 処理年月
     *
     * @return 帳票Entity
     */
    public KuniHoSorenSofuDataCsvEntity setファイル出力(SofuEraRelateEntity entity, RString 市町村コード,
            RString 市町村名称, int 連番, RString 処理年月) {
        KuniHoSorenSofuDataCsvEntity csvEntity = new KuniHoSorenSofuDataCsvEntity();
        csvEntity.set市町村コード(市町村コード);
        csvEntity.set市町村名称(市町村名称);
        csvEntity.set連番(new RString(連番));
        csvEntity.set被保険者番号(entity.get被保険者番号().value());
        csvEntity.set氏名カナ(entity.get氏名カナ());
        csvEntity.set氏名(entity.get氏名());
        csvEntity.set資格取得日(dateChangeToRString(entity.get資格取得日()));
        csvEntity.set認定要介護度(entity.get要介護状態区分コード().value());
        csvEntity.set認定申請日(dateChangeToRString(entity.get要介護認定申請日()));
        csvEntity.set居宅事業者番号(entity.get居宅事業者番号().value());
        csvEntity.set特定申請日(dateChangeToRString(entity.get特定申請日()));
        csvEntity.set特定開始日(dateChangeToRString(entity.get特定適用開始日()));
        csvEntity.set特定終了日(dateChangeToRString(entity.get特定適用終了日()));
        csvEntity.set社福開始日(dateChangeToRString(entity.get社会福祉適用開始日()));
        csvEntity.set社福終了日(dateChangeToRString(entity.get社会福祉適用終了日()));
        csvEntity.set償還開始日(dateChangeToRString(entity.get償還払化開始日()));
        csvEntity.setエラー情報コード(entity.getエラーコード());
        csvEntity.setエラー情報内容(entity.getエラー内容());
        csvEntity.set資格喪失日(dateChangeToRString(entity.get資格喪失日()));
        csvEntity.set認定開始日(dateChangeToRString(entity.get認定開始日()));
        csvEntity.set認定終了日(dateChangeToRString(entity.get認定終了日()));
        csvEntity.set居宅開始日(dateChangeToRString(entity.get居宅適用開始日()));
        csvEntity.set利用申請日(dateChangeToRString(entity.get利用者負担申請日()));
        csvEntity.set利用開始日(dateChangeToRString(entity.get利用者負担適用開始日()));
        csvEntity.set利用終了日(dateChangeToRString(entity.get利用者負担適用終了日()));
        csvEntity.set標準開始日(dateChangeToRString(entity.get標準負担適用開始日()));
        csvEntity.set標準終了日(dateChangeToRString(entity.get標準負担適用終了日()));
        csvEntity.set被下開始日(dateChangeToRString(entity.get給付率引下げ開始日()));
        csvEntity.set作成年月日(new RString(FlexibleDate.getNowDate().toString()));
        csvEntity.set処理年月(処理年月);
        return csvEntity;
    }

    private RString dateChangeToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
