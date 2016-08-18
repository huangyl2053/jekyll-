/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.iraijohodatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.iraijohodatatorikomi.NinteiShinseiJohoIraiJohoData;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.iraijohodatatorikomi.IraiJohoDataTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.iraijohodatatorikomi.IIraiJohoDataTorikomiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 依頼情報データ受取（オルカ）のManagerクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class IraiJohoDataTorikomiManager {

    private static final RString 選択項目 = new RString("1");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
//    private static final int INT_114 = 114;
    private final MapperProvider mapperProvider;
    private final DbT5302ShujiiIkenshoJohoDac dbT5302Dac;
//    private final DbT5303ShujiiIkenshoKinyuItemDac dbT5303Dac;
//    private final DbT5304ShujiiIkenshoIkenItemDac dbT5304Dac;

    /**
     * コンストラクタです。
     */
    IraiJohoDataTorikomiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5302Dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
//        this.dbT5303Dac = InstanceProvider.create(DbT5303ShujiiIkenshoKinyuItemDac.class);
//        this.dbT5304Dac = InstanceProvider.create(DbT5304ShujiiIkenshoIkenItemDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dbT5302Dac DbT5302ShujiiIkenshoJohoDac
     */
    IraiJohoDataTorikomiManager(MapperProvider mapperProvider,
            DbT5302ShujiiIkenshoJohoDac dbT5302Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5302Dac = dbT5302Dac;
//        this.dbT5303Dac = dbT5303Dac;
//        this.dbT5304Dac = dbT5304Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IraiJohoDataTorikomiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IraiJohoDataTorikomiManager}のインスタンス
     */
    public static IraiJohoDataTorikomiManager createInstance() {
        return InstanceProvider.create(IraiJohoDataTorikomiManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会割当委員情報を返します。
     *
     * @param parameter IraiJohoDataTorikomiParameter
     * @param 保険者番号 保険者番号
     * @return ShinsakaiWariateIinJoho
     */
    @Transaction
    public NinteiShinseiJohoIraiJohoData get要介護認定申請情報(IraiJohoDataTorikomiParameter parameter, RString 保険者番号) {
        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
        List<NinteiShinseiJohoRelateEntity> relateEntity = mapper.get要介護認定申請情報(parameter);
        NinteiShinseiJohoRelateEntity entity = new NinteiShinseiJohoRelateEntity();
        if (relateEntity == null) {
            return new NinteiShinseiJohoIraiJohoData(entity);
        }
        for (NinteiShinseiJohoRelateEntity ninteiShinseiJohoRelateEntity : relateEntity) {
            if (保険者番号.equals(ninteiShinseiJohoRelateEntity.getShoKisaiHokenshaNo())) {
                entity = ninteiShinseiJohoRelateEntity;
            }
        }
        return new NinteiShinseiJohoIraiJohoData(entity);
    }

    /**
     * 各テーブルへ登録する。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param business IkenshokinyuyoshiBusiness
     */
    public void 各テーブルへの登録(RString 申請書管理番号, RString 厚労省IF識別コード, RString 主治医医療機関コード, RString 主治医コード,
            IkenshokinyuyoshiBusiness business) {
        DbT5302ShujiiIkenshoJohoEntity shujiiIkenshoIraiJohoJoho = 要介護認定主治医意見書情報(申請書管理番号, 厚労省IF識別コード);
        if (shujiiIkenshoIraiJohoJoho == null) {
            要介護認定主治医意見書情報Insert(申請書管理番号, INT_3, 主治医医療機関コード, 主治医コード, business);
        } else {
            要介護認定主治医意見書情報Updata(shujiiIkenshoIraiJohoJoho, business, 主治医医療機関コード, 主治医コード,
                    get主治医意見書依頼区分(申請書管理番号, 厚労省IF識別コード, shujiiIkenshoIraiJohoJoho.getShujiiCode(),
                            shujiiIkenshoIraiJohoJoho.getShujiiIryoKikanCode()));
        }
        //TODO QA回答待ち
//        List<ShujiiIkenshoIraiJohoIkenItemRelateEntity> ikenItemEntityList = 要介護認定主治医意見書意見項目(申請書管理番号, 厚労省IF識別コード);
//        if (ikenItemEntityList == null || ikenItemEntityList.isEmpty()) {
//            要介護認定主治医意見書意見項目Insert(new ShinseishoKanriNo(申請書管理番号), INT_3);
//        }
//        for (ShujiiIkenshoIraiJohoIkenItemRelateEntity ikenItemEntity : ikenItemEntityList) {
//            if (ikenItemEntity.getEntity() == null) {
//            }
//        }
    }

    private DbT5302ShujiiIkenshoJohoEntity 要介護認定主治医意見書情報(RString 申請書管理番号, RString 厚労省IF識別コード) {
        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
        parameter.set申請書管理番号(申請書管理番号);
        parameter.set厚労省IF識別コード(厚労省IF識別コード);
        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
        return mapper.要介護認定主治医意見書情報(parameter);
    }

//    private List<ShujiiIkenshoIraiJohoIkenItemRelateEntity> 要介護認定主治医意見書意見項目(RString 申請書管理番号, RString 厚労省IF識別コード) {
//        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
//        parameter.set申請書管理番号(申請書管理番号);
//        parameter.set厚労省IF識別コード(厚労省IF識別コード);
//        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
//        return mapper.要介護認定主治医意見書意見項目(parameter);
//    }
//
//    private List<ShujiiIkenshoIraiJohoKinyuItemRelateEntity> 要介護認定主治医意見書記入項目(RString 申請書管理番号, RString 厚労省IF識別コード) {
//        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
//        parameter.set申請書管理番号(申請書管理番号);
//        parameter.set厚労省IF識別コード(厚労省IF識別コード);
//        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
//        return mapper.要介護認定主治医意見書記入項目(parameter);
//    }
    private int 要介護認定主治医意見書情報Insert(RString 申請書管理番号, int 主治医意見書作成依頼履歴番号,
            RString 主治医医療機関コード, RString 主治医コード, IkenshokinyuyoshiBusiness business) {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(new RString("09B"));
        entity.setIkenshoIraiKubun(IkenshoIraiKubun.初回依頼.getコード());
        entity.setShujiiIryoKikanCode(主治医医療機関コード);
        entity.setShujiiCode(主治医コード);
        entity.setIkenshoJuryoYMD(FlexibleDate.getNowDate());
        entity.setIkenshoKinyuYMD(business.get記入日());
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        entity.setIkenshoSakuseiKaisuKubun(rStringToCode(business.get意見書作成回数()));
        entity.setZaitakuShisetsuKubun(rStringToCode(business.get種別()));
        entity.setIkenshoDoiFlag(business.is同意の有無());
        entity.setSaishuShinryoYMD(business.get最終診察日());
        entity.setExistTakaJushinFlag(business.is他科受診有無());
        entity.setExistNaikaJushinFlag(business.get他科名().startsWith(選択項目, 0));
        entity.setExistSeishinkaJushinFlag(business.get他科名().startsWith(選択項目, 1));
        entity.setExistGekaJushinFlag(business.get他科名().startsWith(選択項目, 2));
        entity.setExistSeikeigekaJushinFlag(business.get他科名().startsWith(選択項目, INT_3));
        entity.setExistNoshinkeigekaJushinFlag(business.get他科名().startsWith(選択項目, INT_4));
        entity.setExistHifukaJushinFlag(business.get他科名().startsWith(選択項目, INT_5));
        entity.setExistHinyokikaJushinFlag(business.get他科名().startsWith(選択項目, INT_6));
        entity.setExistFujinkaJushinFlag(business.get他科名().startsWith(選択項目, INT_7));
        entity.setExistJibiinkokaJushinFlag(business.get他科名().startsWith(選択項目, INT_8));
        entity.setExistRehabilitationkaJushinFlag(business.get他科名().startsWith(選択項目, INT_9));
        entity.setExistShikaJushinFlag(business.get他科名().startsWith(選択項目, INT_10));
        entity.setExistGankaJushinFlag(business.get他科名().startsWith(選択項目, INT_11));
        entity.setExistSonotaJushinkaFlag(business.get他科名().startsWith(選択項目, INT_12));
        entity.setSonotaJushinKaMei(business.getその他の他科名());
        entity.setShindamMei1(business.get診断名1());
        entity.setHasshoYMD1(get発症年月日(business.get発症年月日1()));
        entity.setShindamMei2(business.get診断名2());
        entity.setHasshoYMD2(get発症年月日(business.get発症年月日2()));
        entity.setShindamMei3(business.get診断名3());
        entity.setHasshoYMD3(get発症年月日(business.get発症年月日3()));
        entity.setAnteisei(business.get症状安定性());
        entity.setFuanteiJokyo(business.get症状不安定時の具体的状況());
        entity.setChiryoNaiyo(business.get経過及び治療内容());
        entity.setTokkiJiko(business.getその他特記事項());
        entity.setNijiHanteiKekkaRenrakuFlag(false);
        entity.setIkenshoMemo(RString.EMPTY);
        entity.setState(EntityDataState.Added);
        return dbT5302Dac.save(entity);
    }

    private int 要介護認定主治医意見書情報Updata(DbT5302ShujiiIkenshoJohoEntity entity, IkenshokinyuyoshiBusiness business,
            RString 主治医医療機関コード, RString 主治医コード, RString 主治医意見書依頼区分) {
        entity.setIkenshoIraiKubun(主治医意見書依頼区分);
        entity.setShujiiIryoKikanCode(主治医医療機関コード);
        entity.setShujiiCode(主治医コード);
        entity.setIkenshoJuryoYMD(FlexibleDate.getNowDate());
        entity.setIkenshoKinyuYMD(business.get記入日());
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        entity.setIkenshoSakuseiKaisuKubun(rStringToCode(business.get意見書作成回数()));
        entity.setZaitakuShisetsuKubun(rStringToCode(business.get種別()));
        entity.setIkenshoDoiFlag(business.is同意の有無());
        entity.setSaishuShinryoYMD(business.get最終診察日());
        entity.setExistTakaJushinFlag(business.is他科受診有無());
        entity.setExistNaikaJushinFlag(business.get他科名().startsWith(選択項目, 0));
        entity.setExistSeishinkaJushinFlag(business.get他科名().startsWith(選択項目, 1));
        entity.setExistGekaJushinFlag(business.get他科名().startsWith(選択項目, 2));
        entity.setExistSeikeigekaJushinFlag(business.get他科名().startsWith(選択項目, INT_3));
        entity.setExistNoshinkeigekaJushinFlag(business.get他科名().startsWith(選択項目, INT_4));
        entity.setExistHifukaJushinFlag(business.get他科名().startsWith(選択項目, INT_5));
        entity.setExistHinyokikaJushinFlag(business.get他科名().startsWith(選択項目, INT_6));
        entity.setExistFujinkaJushinFlag(business.get他科名().startsWith(選択項目, INT_7));
        entity.setExistJibiinkokaJushinFlag(business.get他科名().startsWith(選択項目, INT_8));
        entity.setExistRehabilitationkaJushinFlag(business.get他科名().startsWith(選択項目, INT_9));
        entity.setExistShikaJushinFlag(business.get他科名().startsWith(選択項目, INT_10));
        entity.setExistGankaJushinFlag(business.get他科名().startsWith(選択項目, INT_11));
        entity.setExistSonotaJushinkaFlag(business.get他科名().startsWith(選択項目, INT_12));
        entity.setSonotaJushinKaMei(business.getその他の他科名());
        entity.setShindamMei1(business.get診断名1());
        entity.setHasshoYMD1(get発症年月日(business.get発症年月日1()));
        entity.setShindamMei2(business.get診断名2());
        entity.setHasshoYMD2(get発症年月日(business.get発症年月日2()));
        entity.setShindamMei3(business.get診断名3());
        entity.setHasshoYMD3(get発症年月日(business.get発症年月日3()));
        entity.setAnteisei(business.get症状安定性());
        entity.setFuanteiJokyo(business.get症状不安定時の具体的状況());
        entity.setChiryoNaiyo(business.get経過及び治療内容());
        entity.setTokkiJiko(business.getその他特記事項());
        entity.setState(EntityDataState.Modified);
        return dbT5302Dac.save(entity);
    }

    private RString get発症年月日(FlexibleDate 発症年月日) {
        if (発症年月日 == null || 発症年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(発症年月日.toString());
    }

//    private int 要介護認定主治医意見書意見項目Insert(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号) {
//        DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
//        entity.setShinseishoKanriNo(申請書管理番号);
//        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
//        entity.setKoroshoIfShikibetsuCode(new Code("09B"));
//        return 主治医意見書意見項目Insert(entity);
//    }
//    private int 主治医意見書意見項目Insert(DbT5304ShujiiIkenshoIkenItemEntity entity) {
//        int count = 0;
//        for (int i = 1; i < INT_114; i++) {
//            entity.setRemban(i);
//            entity.setIkenItem(IkenshoKomokuMapping09B.toValue(new RString(i)).get名称());
//            count = count + dbT5304Dac.save(entity);
//        }
//        return count;
//    }
//    private int 要介護認定主治医意見書意見項目Updata(DbT5304ShujiiIkenshoIkenItemEntity entity) {
//        entity.setIkenItem(IkenshoKomokuMapping09B.toValue(new RString(entity.getRemban())).get名称());
//        return dbT5304Dac.save(entity);
//    }
    private RString get主治医意見書依頼区分(RString 申請書管理番号, RString 厚労省IF識別コード, RString 主治医コード, RString 主治医医療機関コード) {
        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
        parameter.set申請書管理番号(申請書管理番号);
        parameter.set厚労省IF識別コード(厚労省IF識別コード);
        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
        DbT5302ShujiiIkenshoJohoEntity entity = mapper.主治医意見書依頼区分(parameter);
        if (entity != null && !RString.isNullOrEmpty(主治医コード)) {
            if (主治医コード.equals(entity.getShujiiCode())
                    && entity.getShujiiIryoKikanCode().equals(主治医医療機関コード)) {
                return IkenshoIraiKubun.再依頼.getコード();
            } else {
                return IkenshoIraiKubun.初回依頼.getコード();
            }
        }
        return RString.EMPTY;
    }

    private Code rStringToCode(RString 区分) {
        if (!RString.isNullOrEmpty(区分)) {
            return new Code(区分);
        }
        return Code.EMPTY;
    }
}
