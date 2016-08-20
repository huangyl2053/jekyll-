/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.iraijohodatatorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.iraijohodatatorikomi.NinteiShinseiJohoIraiJohoData;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.iraijohodatatorikomi.IraiJohoDataTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.ShujiiIkenshoIraiJohoIkenItemRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.ShujiiIkenshoIraiJohoKinyuItemRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.iraijohodatatorikomi.IIraiJohoDataTorikomiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5303ShujiiIkenshoKinyuItemDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5304ShujiiIkenshoIkenItemDac;
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
    private static final Code B_09 = new Code("09B");
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
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_23 = 23;
    private static final int INT_114 = 114;
    private final MapperProvider mapperProvider;
    private final DbT5302ShujiiIkenshoJohoDac dbT5302Dac;
    private final DbT5303ShujiiIkenshoKinyuItemDac dbT5303Dac;
    private final DbT5304ShujiiIkenshoIkenItemDac dbT5304Dac;

    /**
     * コンストラクタです。
     */
    IraiJohoDataTorikomiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5302Dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
        this.dbT5303Dac = InstanceProvider.create(DbT5303ShujiiIkenshoKinyuItemDac.class);
        this.dbT5304Dac = InstanceProvider.create(DbT5304ShujiiIkenshoIkenItemDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dbT5302Dac DbT5302ShujiiIkenshoJohoDac
     */
    IraiJohoDataTorikomiManager(MapperProvider mapperProvider,
            DbT5302ShujiiIkenshoJohoDac dbT5302Dac,
            DbT5303ShujiiIkenshoKinyuItemDac dbT5303Dac,
            DbT5304ShujiiIkenshoIkenItemDac dbT5304Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5302Dac = dbT5302Dac;
        this.dbT5303Dac = dbT5303Dac;
        this.dbT5304Dac = dbT5304Dac;
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
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param business IkenshokinyuyoshiBusiness
     */
    public void 各テーブルへの登録(RString 申請書管理番号, int 主治医意見書作成依頼履歴番号, RString 厚労省IF識別コード, RString 主治医医療機関コード, RString 主治医コード,
            IkenshokinyuyoshiBusiness business) {
        DbT5302ShujiiIkenshoJohoEntity shujiiIkenshoIraiJohoJoho = 要介護認定主治医意見書情報(申請書管理番号, 厚労省IF識別コード);
        if (shujiiIkenshoIraiJohoJoho == null) {
            insert要介護認定主治医意見書情報(申請書管理番号, 主治医意見書作成依頼履歴番号, 主治医医療機関コード, 主治医コード, business);
        } else {
            updata要介護認定主治医意見書情報(shujiiIkenshoIraiJohoJoho, business, 主治医医療機関コード, 主治医コード,
                    get主治医意見書依頼区分(申請書管理番号, 厚労省IF識別コード, shujiiIkenshoIraiJohoJoho.getShujiiCode(),
                            shujiiIkenshoIraiJohoJoho.getShujiiIryoKikanCode()));
        }
        ShujiiIkenshoIraiJohoIkenItemRelateEntity ikenItemEntity = 要介護認定主治医意見書意見項目(申請書管理番号, 厚労省IF識別コード);
        if (ikenItemEntity == null) {
            insert要介護認定主治医意見書意見項目(new ShinseishoKanriNo(申請書管理番号), 主治医意見書作成依頼履歴番号, business);
        } else {
            if (ikenItemEntity.getEntity() == null || ikenItemEntity.getEntity().isEmpty()) {
                insert要介護認定主治医意見書意見項目(new ShinseishoKanriNo(申請書管理番号), ikenItemEntity.getIkenshoIraiRirekiNo(), business);
            } else {
                update要介護認定主治医意見書意見項目(ikenItemEntity.getEntity(), 申請書管理番号, 主治医意見書作成依頼履歴番号, business);
            }
        }
        ShujiiIkenshoIraiJohoKinyuItemRelateEntity kinyuItemEntity = 要介護認定主治医意見書記入項目(申請書管理番号, 厚労省IF識別コード);
        if (kinyuItemEntity == null) {
            insert要介護認定主治医意見書記入項目(new ShinseishoKanriNo(申請書管理番号), 主治医意見書作成依頼履歴番号, business);
        } else {
            if (kinyuItemEntity.getEntity() == null || kinyuItemEntity.getEntity().isEmpty()) {
                insert要介護認定主治医意見書記入項目(new ShinseishoKanriNo(申請書管理番号), kinyuItemEntity.getIkenshoIraiRirekiNo(), business);
            } else {
                update要介護認定主治医意見書記入項目(kinyuItemEntity.getEntity(), 申請書管理番号, 主治医意見書作成依頼履歴番号, business);
            }
        }
    }

    private DbT5302ShujiiIkenshoJohoEntity 要介護認定主治医意見書情報(RString 申請書管理番号, RString 厚労省IF識別コード) {
        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
        parameter.set申請書管理番号(申請書管理番号);
        parameter.set厚労省IF識別コード(厚労省IF識別コード);
        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
        return mapper.要介護認定主治医意見書情報(parameter);
    }

    private ShujiiIkenshoIraiJohoIkenItemRelateEntity 要介護認定主治医意見書意見項目(RString 申請書管理番号, RString 厚労省IF識別コード) {
        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
        parameter.set申請書管理番号(申請書管理番号);
        parameter.set厚労省IF識別コード(厚労省IF識別コード);
        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
        return mapper.要介護認定主治医意見書意見項目(parameter);
    }

    private ShujiiIkenshoIraiJohoKinyuItemRelateEntity 要介護認定主治医意見書記入項目(RString 申請書管理番号, RString 厚労省IF識別コード) {
        IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
        parameter.set申請書管理番号(申請書管理番号);
        parameter.set厚労省IF識別コード(厚労省IF識別コード);
        IIraiJohoDataTorikomiMapper mapper = mapperProvider.create(IIraiJohoDataTorikomiMapper.class);
        return mapper.要介護認定主治医意見書記入項目(parameter);
    }

    private int insert要介護認定主治医意見書情報(RString 申請書管理番号, int 主治医意見書作成依頼履歴番号,
            RString 主治医医療機関コード, RString 主治医コード, IkenshokinyuyoshiBusiness business) {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード());
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
        entity.setExistNaikaJushinFlag(選択項目.equals(business.get他科名().substring(0, 1)));
        entity.setExistSeishinkaJushinFlag(選択項目.equals(business.get他科名().substring(1, 2)));
        entity.setExistGekaJushinFlag(選択項目.equals(business.get他科名().substring(2, INT_3)));
        entity.setExistSeikeigekaJushinFlag(選択項目.equals(business.get他科名().substring(INT_3, INT_4)));
        entity.setExistNoshinkeigekaJushinFlag(選択項目.equals(business.get他科名().substring(INT_4, INT_5)));
        entity.setExistHifukaJushinFlag(選択項目.equals(business.get他科名().substring(INT_5, INT_6)));
        entity.setExistHinyokikaJushinFlag(選択項目.equals(business.get他科名().substring(INT_6, INT_7)));
        entity.setExistFujinkaJushinFlag(選択項目.equals(business.get他科名().substring(INT_7, INT_8)));
        entity.setExistJibiinkokaJushinFlag(選択項目.equals(business.get他科名().substring(INT_8, INT_9)));
        entity.setExistRehabilitationkaJushinFlag(選択項目.equals(business.get他科名().substring(INT_9, INT_10)));
        entity.setExistShikaJushinFlag(選択項目.equals(business.get他科名().substring(INT_10, INT_11)));
        entity.setExistGankaJushinFlag(選択項目.equals(business.get他科名().substring(INT_11, INT_12)));
        entity.setExistSonotaJushinkaFlag(選択項目.equals(business.get他科名().substring(INT_12, INT_13)));
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

    private int updata要介護認定主治医意見書情報(DbT5302ShujiiIkenshoJohoEntity entity, IkenshokinyuyoshiBusiness business,
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
        entity.setExistNaikaJushinFlag(選択項目.equals(business.get他科名().substring(0, 1)));
        entity.setExistSeishinkaJushinFlag(選択項目.equals(business.get他科名().substring(1, 2)));
        entity.setExistGekaJushinFlag(選択項目.equals(business.get他科名().substring(2, INT_3)));
        entity.setExistSeikeigekaJushinFlag(選択項目.equals(business.get他科名().substring(INT_3, INT_4)));
        entity.setExistNoshinkeigekaJushinFlag(選択項目.equals(business.get他科名().substring(INT_4, INT_5)));
        entity.setExistHifukaJushinFlag(選択項目.equals(business.get他科名().substring(INT_5, INT_6)));
        entity.setExistHinyokikaJushinFlag(選択項目.equals(business.get他科名().substring(INT_6, INT_7)));
        entity.setExistFujinkaJushinFlag(選択項目.equals(business.get他科名().substring(INT_7, INT_8)));
        entity.setExistJibiinkokaJushinFlag(選択項目.equals(business.get他科名().substring(INT_8, INT_9)));
        entity.setExistRehabilitationkaJushinFlag(選択項目.equals(business.get他科名().substring(INT_9, INT_10)));
        entity.setExistShikaJushinFlag(選択項目.equals(business.get他科名().substring(INT_10, INT_11)));
        entity.setExistGankaJushinFlag(選択項目.equals(business.get他科名().substring(INT_11, INT_12)));
        entity.setExistSonotaJushinkaFlag(選択項目.equals(business.get他科名().substring(INT_12, INT_13)));
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

    private int insert要介護認定主治医意見書意見項目(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号,
            IkenshokinyuyoshiBusiness business) {
        DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(B_09);
        return insert主治医意見書意見項目(entity, business);
    }

    private int insert主治医意見書意見項目(DbT5304ShujiiIkenshoIkenItemEntity entity, IkenshokinyuyoshiBusiness business) {
        int count = 0;
        for (int i = 1; i < INT_114; i++) {
            entity.setRemban(i);
            entity.setIkenItem(get09B意見項目1(i, business));
            entity.setState(EntityDataState.Added);
            count = count + dbT5304Dac.save(entity);
        }
        return count;
    }

    private int update要介護認定主治医意見書意見項目(List<DbT5304ShujiiIkenshoIkenItemEntity> entityList,
            RString 申請書管理番号, int 主治医意見書作成依頼履歴番号, IkenshokinyuyoshiBusiness business) {
        int count = 0;
        List<Integer> 連番List = new ArrayList<>();
        for (int i = 1; i < INT_114; i++) {
            連番List.add(i);
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (連番List.contains(entity.getRemban())) {
                entity.setIkenItem(get意見項目(entity.getRemban(), entity.getKoroshoIfShikibetsuCode(), business));
                entity.setState(EntityDataState.Modified);
                count = count + dbT5304Dac.save(entity);
                連番List.remove(entity.getRemban());
            }
        }
        for (Integer 連番 : 連番List) {
            DbT5304ShujiiIkenshoIkenItemEntity dbT5304Entity = new DbT5304ShujiiIkenshoIkenItemEntity();
            dbT5304Entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
            dbT5304Entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
            dbT5304Entity.setRemban(連番);
            dbT5304Entity.setKoroshoIfShikibetsuCode(B_09);
            dbT5304Entity.setIkenItem(get09B意見項目1(連番, business));
            dbT5304Entity.setState(EntityDataState.Added);
            count = count + dbT5304Dac.save(dbT5304Entity);
        }
        return count;
    }

    private int insert要介護認定主治医意見書記入項目(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号,
            IkenshokinyuyoshiBusiness business) {
        DbT5303ShujiiIkenshoKinyuItemEntity entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(B_09);
        return insert主治医意見書記入項目(entity, business);
    }

    private int insert主治医意見書記入項目(DbT5303ShujiiIkenshoKinyuItemEntity entity,
            IkenshokinyuyoshiBusiness business) {
        int count = 0;
        for (int i = 1; i <= INT_23; i++) {
            entity.setRemban(i);
            entity.setKinyuItem(get09B記入項目1(i, business));
            entity.setState(EntityDataState.Added);
            dbT5303Dac.save(entity);
        }
        return count;
    }

    private int update要介護認定主治医意見書記入項目(List<DbT5303ShujiiIkenshoKinyuItemEntity> entityList,
            RString 申請書管理番号, int 主治医意見書作成依頼履歴番号, IkenshokinyuyoshiBusiness business) {
        int count = 0;
        List<Integer> 連番List = new ArrayList<>();
        for (int i = 1; i <= INT_23; i++) {
            連番List.add(i);
        }
        for (DbT5303ShujiiIkenshoKinyuItemEntity entity : entityList) {
            if (連番List.contains(entity.getRemban())) {
                entity.setKinyuItem(get記入項目(entity.getRemban(), entity.getKoroshoIfShikibetsuCode(), business));
                entity.setState(EntityDataState.Modified);
                count = count + dbT5303Dac.save(entity);
                連番List.remove(entity.getRemban());
            }
        }
        for (Integer 連番 : 連番List) {
            DbT5303ShujiiIkenshoKinyuItemEntity dbT5303Entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
            dbT5303Entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
            dbT5303Entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
            dbT5303Entity.setRemban(連番);
            dbT5303Entity.setKoroshoIfShikibetsuCode(B_09);
            dbT5303Entity.setKinyuItem(get09B記入項目1(連番, business));
            dbT5303Entity.setState(EntityDataState.Added);
            count = count + dbT5303Dac.save(dbT5303Entity);
        }
        return count;
    }

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

    private RString get記入項目(int 連番, Code 厚労省IF識別コード, IkenshokinyuyoshiBusiness business) {
        RString 記入項目 = RString.EMPTY;
        if (厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = get02A記入項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = get06A記入項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = get09A記入項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = get09B記入項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = get99A記入項目1(連番, business);
            }
        }
        return 記入項目;
    }

    private RString get意見項目(int 連番, Code 厚労省IF識別コード, IkenshokinyuyoshiBusiness business) {
        RString 記入項目 = RString.EMPTY;
        IkenshoKomoku ikenshoKomoku = new IkenshoKomoku();
        if (厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = ikenshoKomoku.get02A意見項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = ikenshoKomoku.get06A意見項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = ikenshoKomoku.get09A意見項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = get09B意見項目1(連番, business);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                記入項目 = ikenshoKomoku.get99A意見項目1(連番, business);
            }
        }
        return 記入項目;
    }

    private RString get09B記入項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping09B.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKinyuMapping09B.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKinyuMapping09B.身長.getコード().equals(new RString(連番))) {
            return business.get身長();
        } else if (IkenshoKinyuMapping09B.体重.getコード().equals(new RString(連番))) {
            return business.get体重();
        } else if (IkenshoKinyuMapping09B.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKinyuMapping09B.麻痺_その他.getコード().equals(new RString(連番))) {
            return business.get麻痺その他();
        } else if (IkenshoKinyuMapping09B.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKinyuMapping09B.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else if (IkenshoKinyuMapping09B.関節の痛み.getコード().equals(new RString(連番))) {
            return business.get関節痛み();
        } else if (IkenshoKinyuMapping09B.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKinyuMapping09B.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKinyuMapping09B.栄養_食生活上の留意点.getコード().equals(new RString(連番))) {
            return business.get栄養_食生活上の留意点();
        } else if (IkenshoKinyuMapping09B.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKinyuMapping09B.病態_対処方針.getコード().equals(new RString(連番))) {
            return business.get対処方針内容();
        } else if (IkenshoKinyuMapping09B.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKinyuMapping09B.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else {
            return get09B記入項目2(連番, business);
        }
    }

    private RString get09B記入項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKinyuMapping09B.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKinyuMapping09B.介護サービスの留意事項_運動.getコード().equals(new RString(連番))) {
            return business.getサービス提供運動();
        } else if (IkenshoKinyuMapping09B.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKinyuMapping09B.介護サービスの留意事項_その他.getコード().equals(new RString(連番))) {
            return business.getサービス提供その他の留意事項();
        } else if (IkenshoKinyuMapping09B.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get09B意見項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.点滴の管理.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.中心静脈栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.透析.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09B.ストーマの処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09B.酸素療法.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09B.レスピレーター.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09B.気管切開の処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09B.疼痛の看護.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09B.経管栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09B.モニター測定.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.じょくそうの処置.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.カテーテル.getコード().equals(new RString(連番))) {
            return business.get失禁への対応();
        } else if (IkenshoKomokuMapping09B.寝たきり度.getコード().equals(new RString(連番))) {
            return business.get寝たきり度();
        } else if (IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().equals(new RString(連番))) {
            return business.get認知症高齢者の日常生活自立度();
        } else if (IkenshoKomokuMapping09B.短期記憶.getコード().equals(new RString(連番))) {
            return business.get短期記憶();
        } else if (IkenshoKomokuMapping09B.認知能力.getコード().equals(new RString(連番))) {
            return business.get認知能力();
        } else if (IkenshoKomokuMapping09B.伝達能力.getコード().equals(new RString(連番))) {
            return business.get伝達能力();
        } else {
            return get09B意見項目2(連番, business);
        }
    }

    private RString get09B意見項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状有無();
        } else if (IkenshoKomokuMapping09B.幻視_幻聴.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.妄想.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.昼夜逆転.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09B.暴言.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09B.暴行.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09B.介護への抵抗.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09B.火の不始末.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09B.不潔行為.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09B.異食行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09B.性的問題行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09B.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping09B.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKomokuMapping09B.専門医受診の有無.getコード().equals(new RString(連番))) {
            return business.get専門医受診有無();
        } else if (IkenshoKomokuMapping09B.利き腕.getコード().equals(new RString(連番))) {
            return business.get利き腕();
        } else if (IkenshoKomokuMapping09B.過去6カ月の体重の変化.getコード().equals(new RString(連番))) {
            return business.get体重の変化();
        } else {
            return get09B意見項目3(連番, business);
        }
    }

    private RString get09B意見項目3(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKomokuMapping09B.麻痺.getコード().equals(new RString(連番))) {
            return business.get麻痺();
        } else if (IkenshoKomokuMapping09B.麻痺_右上肢.getコード().equals(new RString(連番))) {
            return business.get麻痺右上肢();
        } else if (IkenshoKomokuMapping09B.麻痺_右上肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺右上肢程度();
        } else if (IkenshoKomokuMapping09B.麻痺_左上肢.getコード().equals(new RString(連番))) {
            return business.get麻痺左上肢();
        } else if (IkenshoKomokuMapping09B.麻痺_左上肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺左上肢程度();
        } else if (IkenshoKomokuMapping09B.麻痺_右下肢.getコード().equals(new RString(連番))) {
            return business.get麻痺右下肢();
        } else if (IkenshoKomokuMapping09B.麻痺_右下肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺右下肢程度();
        } else if (IkenshoKomokuMapping09B.麻痺_左下肢.getコード().equals(new RString(連番))) {
            return business.get麻痺左下肢();
        } else if (IkenshoKomokuMapping09B.麻痺_左下肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺左下肢程度();
        } else if (IkenshoKomokuMapping09B.麻痺_その他.getコード().equals(new RString(連番))) {
            return business.get麻痺その他();
        } else if (IkenshoKomokuMapping09B.麻痺_その他_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺その他程度();
        } else if (IkenshoKomokuMapping09B.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKomokuMapping09B.筋力の低下_程度.getコード().equals(new RString(連番))) {
            return business.get筋力低下程度();
        } else if (IkenshoKomokuMapping09B.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else if (IkenshoKomokuMapping09B.関節の拘縮_程度.getコード().equals(new RString(連番))) {
            return business.get関節拘縮程度();
        } else if (IkenshoKomokuMapping09B.関節の痛み.getコード().equals(new RString(連番))) {
            return business.get関節痛み();
        } else {
            return get09B意見項目4(連番, business);
        }
    }

    private RString get09B意見項目4(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.関節の痛み_程度.getコード().equals(new RString(連番))) {
            return business.get関節痛み程度();
        } else if (IkenshoKomokuMapping09B.失調_不随意運動.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動();
        } else if (IkenshoKomokuMapping09B.失調_不随意運動_上肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.失調_不随意運動_上肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.失調_不随意運動_下肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.失調_不随意運動_下肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.失調_不随意運動_体幹_左.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.失調_不随意運動_体幹_右.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKomokuMapping09B.じょくそう_程度.getコード().equals(new RString(連番))) {
            return business.get褥瘡程度();
        } else if (IkenshoKomokuMapping09B.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKomokuMapping09B.その他の皮膚疾患_程度.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾程度();
        } else if (IkenshoKomokuMapping09B.屋外歩行.getコード().equals(new RString(連番))) {
            return business.get屋外歩行();
        } else if (IkenshoKomokuMapping09B.車いすの使用.getコード().equals(new RString(連番))) {
            return business.get車いすの使用();
        } else if (IkenshoKomokuMapping09B.歩行補助具_装具の使用_用いていない.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.歩行補助具_装具の使用_屋外で使用.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.歩行補助具_装具の使用_屋内で使用.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09B.食事行為.getコード().equals(new RString(連番))) {
            return business.get食事行為();
        } else {
            return get09B意見項目5(連番, business);
        }
    }

    private RString get09B意見項目5(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.現在の栄養状態.getコード().equals(new RString(連番))) {
            return business.get現在の栄養状態();
        } else if (IkenshoKomokuMapping09B.尿失禁.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.転倒_骨折.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.移動能力の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09B.褥瘡.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09B.心肺機能の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09B.閉じこもり.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09B.意欲低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09B.徘徊_可能性が高い病態.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09B.低栄養.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09B.摂食_嚥下機能低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09B.脱水.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09B.易感染性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping09B.がん等による疼痛.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_12, INT_13);
        } else if (IkenshoKomokuMapping09B.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKomokuMapping09B.生活機能の維持_改善の見通し.getコード().equals(new RString(連番))) {
            return business.getサービス利用による生活機能の維持_改善の見通し();
        } else {
            return get09B意見項目6(連番, business);
        }
    }

    private RString get09B意見項目6(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.訪問診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.訪問看護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.看護職員による相談.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09B.訪問歯科診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09B.訪問薬剤管理指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09B.訪問リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09B.短期入所療養介護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09B.訪問歯科衛生指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09B.訪問栄養食事指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09B.通所リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09B.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09B.訪問診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping09B.訪問看護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping09B.看護職員による相談_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09B.訪問歯科診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09B.訪問薬剤管理指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else {
            return get09B意見項目7(連番, business);
        }
    }

    private RString get09B意見項目7(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09B.訪問リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09B.短期入所療養介護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09B.訪問歯科衛生指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09B.訪問栄養食事指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09B.通所リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09B.その他の医療系のサービス_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09B.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else if (IkenshoKomokuMapping09B.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKomokuMapping09B.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKomokuMapping09B.介護サービスの留意事項_運動.getコード().equals(new RString(連番))) {
            return business.getサービス提供運動();
        } else if (IkenshoKomokuMapping09B.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKomokuMapping09B.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get09A記入項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping09A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKinyuMapping09A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKinyuMapping09A.身長.getコード().equals(new RString(連番))) {
            return business.get身長();
        } else if (IkenshoKinyuMapping09A.体重.getコード().equals(new RString(連番))) {
            return business.get体重();
        } else if (IkenshoKinyuMapping09A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKinyuMapping09A.麻痺_その他.getコード().equals(new RString(連番))) {
            return business.get麻痺その他();
        } else if (IkenshoKinyuMapping09A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKinyuMapping09A.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else if (IkenshoKinyuMapping09A.関節の痛み.getコード().equals(new RString(連番))) {
            return business.get関節痛み();
        } else if (IkenshoKinyuMapping09A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKinyuMapping09A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKinyuMapping09A.栄養_食生活上の留意点.getコード().equals(new RString(連番))) {
            return business.get栄養_食生活上の留意点();
        } else if (IkenshoKinyuMapping09A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKinyuMapping09A.病態_対処方針.getコード().equals(new RString(連番))) {
            return business.get対処方針内容();
        } else if (IkenshoKinyuMapping09A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKinyuMapping09A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else {
            return get09A記入項目2(連番, business);
        }
    }

    private RString get09A記入項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping09A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKinyuMapping09A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKinyuMapping09A.介護サービスの留意事項_運動.getコード().equals(new RString(連番))) {
            return business.getサービス提供運動();
        } else if (IkenshoKinyuMapping09A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKinyuMapping09A.介護サービスの留意事項_その他.getコード().equals(new RString(連番))) {
            return business.getサービス提供その他の留意事項();
        } else if (IkenshoKinyuMapping09A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get06A記入項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping06A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKinyuMapping06A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKinyuMapping06A.身長.getコード().equals(new RString(連番))) {
            return business.get身長();
        } else if (IkenshoKinyuMapping06A.体重.getコード().equals(new RString(連番))) {
            return business.get体重();
        } else if (IkenshoKinyuMapping06A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKinyuMapping06A.麻痺_その他.getコード().equals(new RString(連番))) {
            return business.get麻痺その他();
        } else if (IkenshoKinyuMapping06A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKinyuMapping06A.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else if (IkenshoKinyuMapping06A.関節の痛み.getコード().equals(new RString(連番))) {
            return business.get関節痛み();
        } else if (IkenshoKinyuMapping06A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKinyuMapping06A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKinyuMapping06A.栄養_食生活上の留意点.getコード().equals(new RString(連番))) {
            return business.get栄養_食生活上の留意点();
        } else if (IkenshoKinyuMapping06A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKinyuMapping06A.病態_対処方針.getコード().equals(new RString(連番))) {
            return business.get対処方針内容();
        } else if (IkenshoKinyuMapping06A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKinyuMapping06A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else {
            return get06A記入項目2(連番, business);
        }
    }

    private RString get06A記入項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKinyuMapping06A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKinyuMapping06A.介護サービスの留意事項_運動.getコード().equals(new RString(連番))) {
            return business.getサービス提供運動();
        } else if (IkenshoKinyuMapping06A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKinyuMapping06A.介護サービスの留意事項_その他.getコード().equals(new RString(連番))) {
            return business.getサービス提供その他の留意事項();
        } else if (IkenshoKinyuMapping06A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get02A記入項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping02A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKinyuMapping02A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKinyuMapping02A.身長.getコード().equals(new RString(連番))) {
            return business.get身長();
        } else if (IkenshoKinyuMapping02A.体重.getコード().equals(new RString(連番))) {
            return business.get体重();
        } else if (IkenshoKinyuMapping02A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKinyuMapping02A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKinyuMapping02A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKinyuMapping02A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKinyuMapping02A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKinyuMapping02A.病態_対処方針.getコード().equals(new RString(連番))) {
            return business.get対処方針内容();
        } else if (IkenshoKinyuMapping02A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKinyuMapping02A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else {
            return get02A記入項目2(連番, business);
        }
    }

    private RString get02A記入項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping02A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKinyuMapping02A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKinyuMapping02A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKinyuMapping02A.介護サービスの留意事項_その他.getコード().equals(new RString(連番))) {
            return business.getサービス提供その他の留意事項();
        } else if (IkenshoKinyuMapping02A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get99A記入項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping99A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKinyuMapping99A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKinyuMapping99A.身長.getコード().equals(new RString(連番))) {
            return business.get身長();
        } else if (IkenshoKinyuMapping99A.体重.getコード().equals(new RString(連番))) {
            return business.get体重();
        } else if (IkenshoKinyuMapping99A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKinyuMapping99A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKinyuMapping99A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKinyuMapping99A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKinyuMapping99A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKinyuMapping99A.病態_対処方針.getコード().equals(new RString(連番))) {
            return business.get対処方針内容();
        } else if (IkenshoKinyuMapping99A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKinyuMapping99A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else {
            return get99A記入項目2(連番, business);
        }
    }

    private RString get99A記入項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKinyuMapping99A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKinyuMapping99A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKinyuMapping99A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKinyuMapping99A.介護サービスの留意事項_その他.getコード().equals(new RString(連番))) {
            return business.getサービス提供その他の留意事項();
        } else if (IkenshoKinyuMapping99A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }
}
