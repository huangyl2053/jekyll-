/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd206010;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010.DBD206010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.KeikakuJigyoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.TyohyoShutuyukuItokiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のprocessクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public class KeikakuJigyoshaJohoProcess extends BatchProcessBase<KeikakuJigyoshaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.jigyoshomukeshakai.IKeikakuJigyoshaJohoMapper.get計画事業者情報");
    private DBD206010ProcessParameter processParameter;
    private IOutputOrder outputOrder;
    private static RStringBuilder orderByClause;
    private static RString space;
    private RString orderBy = null;
    private static RString comma;
    private static int commaCount;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tyohyoShutuyukuItokiTemp;

    @Override
    protected void initialize() {
        if (processParameter.get改頁出力順ID() != 0) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            long 帳票出力順ID = processParameter.get改頁出力順ID();
            outputOrder = chohyoShutsuryokujunFinder.get出力順(
                    SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200017.getReportId(), 帳票出力順ID);
            if (null != outputOrder) {
                orderBy = createOrderSqlStr(TyohyoShutuyukuOrderKey.class, outputOrder);
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDBD206010MybatisParameter(orderBy));
    }

    @Override
    protected void createWriter() {
        tyohyoShutuyukuItokiTemp = new BatchEntityCreatedTempTableWriter(TyohyoShutuyukuItokiTempEntity.TABLE_NAME,
                TyohyoShutuyukuItokiTempEntity.class);
    }

    @Override
    protected void process(KeikakuJigyoshaJohoEntity entity) {
        if (entity.get計画事業者番号() != null && !entity.get計画事業者番号().isEmpty()) {
            TyohyoShutuyukuItokiTempEntity tempTable = new TyohyoShutuyukuItokiTempEntity();
            set帳票出力用一時テーブル(entity, tempTable);
            tyohyoShutuyukuItokiTemp.insert(tempTable);
        }
    }

    private void set帳票出力用一時テーブル(KeikakuJigyoshaJohoEntity entity, TyohyoShutuyukuItokiTempEntity tempTable) {
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
        tempTable.setEditPattern(new RString("1"));
    }

    private static <T extends Enum<T> & IReportItems> RString createOrderSqlStr(Class<T> clazz, IOutputOrder outputOrder) {
        ReportItemsMap reportItems = new ReportItemsMap(Arrays.<IReportItems>asList(clazz.getEnumConstants()));
        orderByClause = new RStringBuilder("order by");
        space = new RString(" ");
        comma = new RString(",");
        commaCount = 0;
        if (outputOrder.get設定項目リスト().isEmpty()) {
            return RString.EMPTY;
        }
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {

            if (commaCount != 0) {
                orderByClause = orderByClause.append(space).append(comma).append(space)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(space).append(setSortItem.get昇降順().getOrder());

            } else {
                setSortItem.get項目名();
                setSortItem.getDB項目名();
                setSortItem.get帳票フィールド名();
                orderByClause = orderByClause.append(space)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(space).append(setSortItem.get昇降順().getOrder());
            }
            commaCount++;
        }

        return orderByClause.toRString();
    }

    private static class ReportItemsMap {

        private Map<RString, IReportItems> map;

        public ReportItemsMap(List<IReportItems> items) {
            this.map = new HashMap<>();
            for (IReportItems item : items) {
                this.map.put(item.get項目ID(), item);
            }
            this.map = Collections.unmodifiableMap(map);
        }

        RString getMyBatis項目名(RString 項目ID) throws IllegalArgumentException {
            if (this.map.containsKey(項目ID)) {
                return this.map.get(項目ID).getMyBatis項目名();
            } else {
                throw new IllegalArgumentException(UrErrorMessages.データが存在しない.toString());
            }
        }
    }
}
