/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd206010;

import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.JigyoshaSentaku;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.KeikakuJigyoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.SabisuKeikakuJigyoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.TyohyoShutuyukuItokiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のDataManagerクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public class JigyoshomukeshakaiDataManager {

    /**
     * コンストラクタです。
     */
    public JigyoshomukeshakaiDataManager() {
    }

    /**
     * 帳票出力用一時テーブルを設定します。
     *
     * @param entity KeikakuJigyoshaJohoEntity
     * @param tempTable TyohyoShutuyukuItokiTempEntity
     * @return TyohyoShutuyukuItokiTempEntity
     */
    public TyohyoShutuyukuItokiTempEntity set帳票出力用一時テーブル(KeikakuJigyoshaJohoEntity entity, TyohyoShutuyukuItokiTempEntity tempTable) {
        tempTable.setJigyoshaNo(entity.get計画事業者番号());
        tempTable.setJigyoshaName(entity.get事業者名称());
        tempTable.setJigyoshaNameKana(entity.get事業者名称カナ());
        tempTable.setYubinNo(entity.get郵便番号());
        tempTable.setJigyoshaAddress(entity.get事業者住所());
        tempTable.setTelNo(entity.get電話番号());
        tempTable.setYukoKaishiYMD(entity.get有効開始日());
        tempTable.setYukoShuryoYMD(entity.get有効終了日());
        tempTable.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        tempTable.setHihokenshaNo(entity.get被保険者番号());
        tempTable.setRirekiNo(entity.get履歴番号());
        tempTable.setKyotakuServiceGentei(entity.is居宅サービス限定());
        tempTable.setKyojuhiShokuhiNomi(entity.is居住費食費のみ());
        tempTable.setKyusochishaUnitTypeKoshitsuNomi(entity.is旧措置者ユニット型個室のみ());
        tempTable.setKakuninNo(entity.get確認番号());
        tempTable.setTekiyoKaishiYMD(entity.get適用開始年月日());
        tempTable.setTekiyoShuryoYMD(entity.get適用終了年月日());
        tempTable.setShikibetsuCode(entity.get識別コード());
        tempTable.setHihokennshaKubunCode(entity.get被保険者区分コード());
        tempTable.setShikakuShutokuYMD(entity.get資格取得年月日());
        tempTable.setShikakuShutokuJiyuCode(entity.get資格取得事由コード());
        tempTable.setShikakuSoshitsuYMD(entity.get資格喪失年月日());
        tempTable.setShikakuHenkoJiyuCode(entity.get資格喪失事由コード());
        tempTable.setJushochiTokureiFlag(entity.is住所地特例フラグ());
        tempTable.setKoikinaiJushochiTokureiFlag(entity.is広域内住所地特例フラグ());
        tempTable.setKoikinaiTokureiSochimotoShichosonCode(entity.get広住特措置元市町村コード());
        tempTable.setShichosonCode(entity.get市町村コード());
        tempTable.setKyuShichosonCode(entity.get旧市町村コード());
        tempTable.setYokaigoJotaiKubunCode(entity.get要介護認定状態区分コード());
        tempTable.setNinteiYukoKikanKaishiYMD(entity.get認定有効期間開始年月日());
        tempTable.setNinteiYukoKikanShuryoYMD(entity.get認定有効期間終了年月日());
        tempTable.setTaishoYM(entity.get対象年月());
        tempTable.setSakuseiKubunCode(entity.get作成区分コード());
        tempTable.setKeikakuJigyoshaNo(entity.get計画事業者番号());
        tempTable.setInputShikibetsuNo(NyuryokuShikibetsuNo.EMPTY);
        tempTable.setShinsaYM(FlexibleYearMonth.EMPTY);
        tempTable.setEditPattern(JigyoshaSentaku.計画事業者.getコード());
        return tempTable;
    }

    /**
     * 帳票出力用一時テーブルTwoを設定します。
     *
     * @param entity SabisuKeikakuJigyoshaJohoEntity
     * @param tempTable TyohyoShutuyukuItokiTempEntity
     * @return TyohyoShutuyukuItokiTempEntity
     */
    public TyohyoShutuyukuItokiTempEntity set帳票出力用一時テーブルTwo(SabisuKeikakuJigyoshaJohoEntity entity, TyohyoShutuyukuItokiTempEntity tempTable) {
        tempTable.setJigyoshaNo(entity.get事業所番号());
        tempTable.setJigyoshaName(entity.get事業者名称());
        tempTable.setJigyoshaNameKana(entity.get事業者名称カナ());
        tempTable.setYubinNo(entity.get郵便番号());
        tempTable.setJigyoshaAddress(entity.get事業者住所());
        tempTable.setTelNo(entity.get電話番号());
        tempTable.setYukoKaishiYMD(entity.get有効開始日());
        tempTable.setYukoShuryoYMD(entity.get有効終了日());
        tempTable.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        tempTable.setHihokenshaNo(entity.get被保険者番号());
        tempTable.setRirekiNo(entity.get履歴番号());
        tempTable.setKyotakuServiceGentei(entity.is居宅サービス限定());
        tempTable.setKyojuhiShokuhiNomi(entity.is居住費食費のみ());
        tempTable.setKyusochishaUnitTypeKoshitsuNomi(entity.is旧措置者ユニット型個室のみ());
        tempTable.setKakuninNo(entity.get確認番号());
        tempTable.setTekiyoKaishiYMD(entity.get適用開始年月日());
        tempTable.setTekiyoShuryoYMD(entity.get適用終了年月日());
        tempTable.setShikibetsuCode(entity.get識別コード());
        tempTable.setHihokennshaKubunCode(entity.get被保険者区分コード());
        tempTable.setShikakuShutokuYMD(entity.get資格取得年月日());
        tempTable.setShikakuShutokuJiyuCode(entity.get資格取得事由コード());
        tempTable.setShikakuSoshitsuYMD(entity.get資格喪失年月日());
        tempTable.setShikakuHenkoJiyuCode(entity.get資格喪失事由コード());
        tempTable.setJushochiTokureiFlag(entity.is住所地特例フラグ());
        tempTable.setKoikinaiJushochiTokureiFlag(entity.is広域内住所地特例フラグ());
        tempTable.setKoikinaiTokureiSochimotoShichosonCode(entity.get広住特措置元市町村コード());
        tempTable.setShichosonCode(entity.get市町村コード());
        tempTable.setKyuShichosonCode(entity.get旧市町村コード());
        tempTable.setYokaigoJotaiKubunCode(entity.get要介護認定状態区分コード());
        tempTable.setNinteiYukoKikanKaishiYMD(entity.get認定有効期間開始年月日());
        tempTable.setNinteiYukoKikanShuryoYMD(entity.get認定有効期間終了年月日());

        tempTable.setTaishoYM(entity.getサービス提供年月());
        tempTable.setSakuseiKubunCode(entity.get給付実績情報作成区分コード());
        tempTable.setKeikakuJigyoshaNo(entity.get事業所番号());

        tempTable.setInputShikibetsuNo(NyuryokuShikibetsuNo.EMPTY);
        tempTable.setShinsaYM(FlexibleYearMonth.EMPTY);

        tempTable.setEditPattern(JigyoshaSentaku.サービス事業者.getコード());
        return tempTable;
    }
}
