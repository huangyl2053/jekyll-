/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 高額サービス費支給決定通知書作成（バッチ）のクラスです。
 *
 * @reamsid_L DBC-2000-130 xicongwang
 */
public class ServicehiShikyuKetteiTsuchisho {

    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名1 = new RString("シーラタイプタイトル１");
    private static final RString 項目名2 = new RString("シーラタイプタイトル２");
    private static final RString 資格状態区分_1 = new RString("1");
    private static final RString 審査方法区分_審査済み = new RString("2");

    /**
     * {@link InstanceProvider#create}にて生成した{@link ServicehiShikyuKetteiTsuchisho}のインスタンスを返します。
     *
     * @return ServicehiShikyuKetteiTsuchisho
     */
    public static ServicehiShikyuKetteiTsuchisho createInstance() {
        return InstanceProvider.create(ServicehiShikyuKetteiTsuchisho.class);
    }

    /**
     * 高額介護サービスの場合、決定通知書情報を取得します。
     *
     * @param entity KetteiTsuchishoInfoTempResultEntity
     * @return KetteiTsuchishoInfoTempEntity
     */
    public KetteiTsuchishoInfoTempEntity to高額介護サービスの決定通知書情報(KetteiTsuchishoInfoTempResultEntity entity) {
        KetteiTsuchishoInfoTempEntity tempEntity = to決定通知書情報(entity);
        if (審査方法区分_審査済み.equals(entity.get審査方法区分())) {
            tempEntity.setKetteiShikyuKubunCode(entity.get判定支給区分コード());
            tempEntity.setKogakuShikyuGaku(entity.get支給金額());
            tempEntity.setRiyoshaFutanGaku(entity.get本人支払額());
        } else {
            tempEntity.setKetteiShikyuKubunCode(entity.get支給区分コード());
            tempEntity.setKogakuShikyuGaku(entity.get高額支給額());
            tempEntity.setRiyoshaFutanGaku(entity.get利用者負担額());
        }
        return tempEntity;
    }

    /**
     * 事業高額介護サービスの場合、決定通知書情報を取得します。
     *
     * @param entity KetteiTsuchishoInfoTempResultEntity
     * @return KetteiTsuchishoInfoTempEntity
     */
    public KetteiTsuchishoInfoTempEntity to事業高額の決定通知書情報(KetteiTsuchishoInfoTempResultEntity entity) {
        KetteiTsuchishoInfoTempEntity tempEntity = to決定通知書情報(entity);
        tempEntity.setKetteiShikyuKubunCode(entity.get支給区分コード());
        tempEntity.setKogakuShikyuGaku(entity.get高額支給額());
        tempEntity.setRiyoshaFutanGaku(entity.get利用者負担額());
        return tempEntity;
    }

    /**
     * 決定通知書情報取得するメソッドです。
     *
     * @param entity KetteiTsuchishoInfoTempResultEntity
     * @return KetteiTsuchishoInfoTempEntity 決定通知書情報
     */
    public KetteiTsuchishoInfoTempEntity to決定通知書情報(KetteiTsuchishoInfoTempResultEntity entity) {

        KetteiTsuchishoInfoTempEntity tmpEntity = new KetteiTsuchishoInfoTempEntity();
        tmpEntity.setHihokenshaNo(entity.get被保険者番号());
        tmpEntity.setServiceTeikyoYM(entity.getサービス提供年月());
        tmpEntity.setRirekiNo(entity.get履歴番号());
        tmpEntity.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        tmpEntity.setUketsukeYMD(entity.get受付年月日());
        tmpEntity.setShiharaiHohoKubunCode(entity.get支払方法区分コード());
        tmpEntity.setShiharaiBasho(entity.get支払場所());
        tmpEntity.setShiharaiKaishiYMD(entity.get支払期間開始年月日());
        tmpEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        tmpEntity.setShiharaiKaishiTime(entity.get支払窓口開始時間());
        tmpEntity.setShiharaiShuryoTime(entity.get支払窓口終了期間());
        tmpEntity.setKozaID(entity.get口座ID());
        tmpEntity.setKetteiYMD(entity.get決定年月日());
        tmpEntity.setTsuchishoNo(entity.get決定通知No());
        tmpEntity.setFushikyuRiyu(entity.get不支給理由());
        tmpEntity.setHanteiShikyuKubunCode(entity.get判定支給区分コード());
        tmpEntity.setShikyuKingaku(entity.get支給金額());
        tmpEntity.setShinsaHohoKubun(entity.get審査方法区分());
        tmpEntity.setHonninShiharaiGaku(entity.get本人支払額());
        tmpEntity.setJidoShokanTaishoFlag(entity.is自動償還対象フラグ());
        tmpEntity.setShikakuSoshitsuYMD(entity.get資格喪失年月日());
        tmpEntity.setShikibetsuCode(entity.get識別コード());
        tmpEntity.setShikakuSoshitsuJiyuCode(entity.get資格喪失事由コード());
        tmpEntity.setYokaigoJotaiKubunCode(entity.get要介護認定状態区分コード());
        tmpEntity.setNinteiYukoKikanKaishiYMD(entity.get認定有効期間開始年月日());
        tmpEntity.setNinteiYukoKikanShuryoYMD(entity.get認定有効期間終了年月日());
        tmpEntity.setShichosonCode(entity.get市町村コード());
        if (entity.get資格喪失年月日() != null && !entity.get資格喪失年月日().isEmpty()) {
            tmpEntity.setShikakuJyotaiKubun(資格状態区分_1);
        } else {
            tmpEntity.setShikakuJyotaiKubun(RString.EMPTY);
        }
        tmpEntity.setGokeiRirekiNo(entity.get給付対象者合計履歴番号());
        tmpEntity.setServiceShuruiName(RString.EMPTY);
        return tmpEntity;
    }

    /**
     * 帳票用のタイトルListを取得する。
     *
     * @param 帳票分類ID ReportId
     * @return List<RString>
     */
    public List<RString> getタイトル(ReportId 帳票分類ID) {
        RString title = RString.EMPTY;
        RString title1 = RString.EMPTY;
        RString title2 = RString.EMPTY;
        DbT7067ChohyoSeigyoHanyoDac dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity1 = dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名1);
        DbT7067ChohyoSeigyoHanyoEntity entity2 = dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名2);
        if (entity2 == null || RString.isNullOrEmpty(entity2.getKomokuValue())) {
            title = entity1.getKomokuValue();
        } else {
            title1 = entity1.getKomokuValue();
            title2 = entity2.getKomokuValue();
        }
        List<RString> titleList = new ArrayList<>();
        titleList.add(title);
        titleList.add(title1);
        titleList.add(title2);
        return titleList;
    }

    /**
     * 設定値を取得する。
     *
     * @param 帳票分類ID ReportId
     * @param 項目名 RString
     * @return 設定値
     */
    public RString get設定値(ReportId 帳票分類ID, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoDac dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return RString.EMPTY;
        }
        return entity.getKomokuValue();
    }
}
