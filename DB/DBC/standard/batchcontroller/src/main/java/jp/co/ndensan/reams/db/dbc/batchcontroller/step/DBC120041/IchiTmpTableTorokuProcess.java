/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C30KyoudouShori;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.KyoudouShoriRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一時TBLの登録Processクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
public class IchiTmpTableTorokuProcess extends BatchProcessBase<KyoudouShoriRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushainsub."
            + "IKyufuJissekiInMapper.get三つ一時TBLを結合結果");
    private static final RString TABLE_共同処理一時TBL = new RString("DbWT5C30KyoudouShori");
    private static final RString TABLE_被保険者一時TBL = new RString("DbWT0001Hihokensha");
    private static final RString TABLE_処理結果リスト一時TBL = new RString("DbWT0002KokuhorenTorikomiError");
    private Decimal renban;
    /**
     * 登録件数です。
     */
    public static final RString 登録件数;

    static {
        登録件数 = new RString("outData");
    }
    private OutputParameter<Integer> outData;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 共同処理一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;

    @Override
    protected void initialize() {
        outData = new OutputParameter<>();
        renban = Decimal.ZERO;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        共同処理一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_共同処理一時TBL,
                DbWT5C30KyoudouShori.class);
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_被保険者一時TBL,
                DbWT0001HihokenshaEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果リスト一時TBL,
                DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(KyoudouShoriRelateEntity entity) {
        renban = renban.add(1);
        共同処理一時TBL.insert(getDbWT5C30KyoudouShori(entity, renban));
        被保険者一時TBL.insert(getDbWT0001HihokenshaEntity(entity, renban));
    }

    @Override
    protected void afterExecute() {
        outData.setValue(Integer.valueOf((int) 共同処理一時TBL.getInsertCount()));
        if (共同処理一時TBL.getInsertCount() == 0) {
            処理結果リスト一時TBL.insert(getDbWT0002ErrorEntity());
        }
    }

    private DbWT0001HihokenshaEntity getDbWT0001HihokenshaEntity(KyoudouShoriRelateEntity relateEntity, Decimal renban) {
        DbWT0001HihokenshaEntity entity = new DbWT0001HihokenshaEntity();
        entity.setMeisaiRenban(renban);
        entity.setOrgHihokenshaNo(toHihokenshaNo(relateEntity.get集約被保険者番号()));
        entity.setServiceTeikyoYmd(toFlexibleDate(relateEntity.get集約異動年月日()));
        entity.setHihokenshaNo(toHihokenshaNo(relateEntity.get集約被保険者番号()));
        return entity;
    }

    private DbWT5C30KyoudouShori getDbWT5C30KyoudouShori(KyoudouShoriRelateEntity relateEntity, Decimal renban) {
        DbWT5C30KyoudouShori entity = new DbWT5C30KyoudouShori();
        entity.setRenban(renban);
        entity.setHokenshaNo(relateEntity.get集約保険者番号());
        entity.setHokenshaName(relateEntity.get集約保険者名());
        entity.setHiHokenshaNo(relateEntity.get集約被保険者番号());
        entity.setIdoYMD(relateEntity.get集約異動年月日());
        entity.setKihon_shikibetsuNo(relateEntity.get基_交換情報識別番号());
        entity.setKihon_idoYMD(relateEntity.get基_異動年月日());
        entity.setKihon_idoKubunCode(relateEntity.get基_異動区分コード());
        entity.setKihon_teiseiKubunCode(relateEntity.get基_訂正区分コード());
        entity.setKihon_teiseiYMD(relateEntity.get基_訂正年月日());
        entity.setKihon_jukyushaIdoJiyu(relateEntity.get基_異動事由());
        entity.setKihon_shoKisaiHokenshaNo(relateEntity.get基_証記載保険者番号());
        entity.setKihon_hiHokenshaNo(relateEntity.get基_被保険者番号());
        entity.setKihon_hiHokenshaName(relateEntity.get基_被保険者氏名());
        entity.setKihon_telNo(relateEntity.get基_電話番号());
        entity.setKihon_yubinNo(relateEntity.get基_郵便番号());
        entity.setKihon_ddressKana(relateEntity.get基_住所カナ());
        entity.setKihon_address(relateEntity.get基_住所());
        entity.setKihon_chohyoOutputJunjyoCode(relateEntity.get基_帳票出力順序コード());
        entity.setShokan_shikibetsuNo(relateEntity.get償_交換情報識別番号());
        entity.setShokan_idoYMD(relateEntity.get償_異動年月日());
        entity.setShokan_idoKubunCode(relateEntity.get償_異動区分コード());
        entity.setShokan_teiseiYMD(relateEntity.get償_訂正年月日());
        entity.setShokan_teiseiKubunCode(relateEntity.get償_訂正区分コード());
        entity.setShokan_jukyushaIdoJiyu(relateEntity.get償_異動事由());
        entity.setShokan_shoKisaiHokenshaNo(relateEntity.get償_証記載保険者番号());
        entity.setShokan_hiHokenshaNo(relateEntity.get償_被保険者番号());
        entity.setShokan_SashitomeKaishiYMD(relateEntity.get償_保険給付支払の一時差止の開始年月日());
        entity.setShokan_SashitomeShuryoYMD(relateEntity.get償_保険給付支払の一時差止の終了年月日());
        entity.setShokan_SashitomeKubunCode(relateEntity.get償_保険給付支払の一時差止区分());
        entity.setShokan_SashitomeKingaku(relateEntity.get償_保険給付支払の一時差止金額());
        entity.setKogaku_shikibetsuNo(relateEntity.get高_交換情報識別番号());
        entity.setKogaku_idoYMD(relateEntity.get高_異動年月日());
        entity.setKogaku_idoKubunCode(relateEntity.get高_異動区分コード());
        entity.setKogaku_teiseiYMD(relateEntity.get高_訂正年月日());
        entity.setKogaku_teiseiKubunCode(relateEntity.get高_訂正区分コード());
        entity.setKogaku_jukyushaIdoJiyu(relateEntity.get高_異動事由());
        entity.setKogaku_shoKisaiHokenshaNo(relateEntity.get高_証記載保険者番号());
        entity.setKogaku_hiHokenshaNo(relateEntity.get高_被保険者番号());
        entity.setKogaku_setaiShuyakuNo(relateEntity.get高_世帯主被保険者番号());
        entity.setKogaku_setaiShotokuKubunCode(relateEntity.get高_世帯所得区分コード());
        entity.setKogaku_shotokuKubunCode(relateEntity.get高_所得区分コード());
        entity.setKogaku_nenkinJukyuAriFlag(relateEntity.get高_老齢福祉年金受給の有無());
        entity.setKogaku_futan2DankaiAriFlag(relateEntity.get高_利用者負担第２段階());
        entity.setKogaku_outputAriFlag(relateEntity.get高_支給申請書出力の有無());
        return entity;
    }

    private DbWT0002KokuhorenTorikomiErrorEntity getDbWT0002ErrorEntity() {
        DbWT0002KokuhorenTorikomiErrorEntity entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        return entity;
    }

    private FlexibleDate toFlexibleDate(RString 集約異動年月日) {
        if (!RString.isNullOrEmpty(集約異動年月日)) {
            return new FlexibleDate(集約異動年月日);
        }
        return FlexibleDate.EMPTY;
    }

    private HihokenshaNo toHihokenshaNo(RString 被保険者番号) {
        if (!RString.isNullOrEmpty(被保険者番号)) {
            return new HihokenshaNo(被保険者番号);
        }
        return HihokenshaNo.EMPTY;
    }
}
