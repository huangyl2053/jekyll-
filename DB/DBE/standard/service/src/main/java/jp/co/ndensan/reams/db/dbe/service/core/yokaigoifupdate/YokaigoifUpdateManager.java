/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoifupdate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoifupdate.YokaigoifUpdateMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoifupdate.YokaigoifUpdateRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoifupdate.IYokaigoifUpdateRelateMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4003YokaigoNinteiInterfaceDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定IF更新を管理するクラスです。
 *
 * @reamsid_L DBE-3000-310 jinjue
 */
public class YokaigoifUpdateManager {

    private final DbT4003YokaigoNinteiInterfaceDac dac;
    private final MapperProvider mapperProvider;

    YokaigoifUpdateManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT4003YokaigoNinteiInterfaceDac.class);
    }

    YokaigoifUpdateManager(MapperProvider mapperProvider, DbT4003YokaigoNinteiInterfaceDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoifUpdateManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link YokaigoifUpdateManager}のインスタンス
     */
    public static YokaigoifUpdateManager createInstance() {
        return InstanceProvider.create(YokaigoifUpdateManager.class);
    }

    /**
     * 「要介護認定インターフェイス情報」を更新（登録）を行う機能です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param フェーズ番号 フェーズ番号
     */
    public void tourokuKoushin(RString フェーズ番号, YokaigoifUpdateMybitisParamter 申請書管理番号) {

        RString 進捗 = new RString("0");
        RString 消込済 = new RString("1");
        List<DbT4003YokaigoNinteiInterfaceEntity> インターフェース情報 = this.getインターフェース情報(申請書管理番号);
        List<YokaigoifUpdateRelateEntity> 情報_登録 = this.get情報_登録(申請書管理番号);
        if (インターフェース情報 == null) {
            DbT4003YokaigoNinteiInterfaceEntity 主治医情報 = this.get_Entity1(情報_登録, new ShinseishoKanriNo(申請書管理番号.get申請書管理番号()));
            if (主治医情報 != null) {
                主治医情報.initializeMd5();
                主治医情報.setState(EntityDataState.Added);
                this.save主治医情報(主治医情報);
            } else {
                主治医情報 = new DbT4003YokaigoNinteiInterfaceEntity();
                主治医情報.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号.get申請書管理番号()));
                主治医情報.initializeMd5();
                主治医情報.setState(EntityDataState.Added);
                this.save主治医情報(主治医情報);
            }
        } else {
            DbT4003YokaigoNinteiInterfaceEntity 主治医情報 = インターフェース情報.get(0);
            RString 履歴番号 = 主治医情報.getRirekiNo();
            RString 取込区分 = 主治医情報.getTorikomiKubun();
            RString 消し込みフラグ = 主治医情報.getKeshikomiFlag();
            if (消込済.equals(フェーズ番号) && !RString.EMPTY.equals(履歴番号)) {
                主治医情報 = this.get主治医情報(消し込みフラグ, 消込済, 進捗, 取込区分, 情報_登録);
                主治医情報.initializeMd5();
                主治医情報.setState(EntityDataState.Modified);
                this.save主治医情報(主治医情報);
            } else if (消込済.equals(フェーズ番号) && インターフェース情報.isEmpty()) {
                主治医情報 = this.get_Entity1(情報_登録, new ShinseishoKanriNo(申請書管理番号.get申請書管理番号()));
                主治医情報.initializeMd5();
                主治医情報.setState(EntityDataState.Added);
                this.save主治医情報(主治医情報);
            } else if (!消込済.equals(フェーズ番号)) {
                this.tourokuKoushin_2(フェーズ番号, 申請書管理番号);
            }
        }
    }

    /**
     * 「要介護認定インターフェイス情報」を更新（クリア）を行う機能です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param フェーズ番号 フェーズ番号
     */
    public void kuria(RString フェーズ番号, YokaigoifUpdateMybitisParamter 申請書管理番号) {

        RString 番号_1 = new RString("1");
        RString 番号_2 = new RString("2");
        RString 番号_3 = new RString("3");
        RString 番号_4 = new RString("4");
        RString 番号_5 = new RString("5");
        RString 番号_6 = new RString("6");
        RString 番号_8 = new RString("8");
        RString 番号_9 = new RString("9");
        List<DbT4003YokaigoNinteiInterfaceEntity> インターフェース情報 = this.getインターフェース情報(申請書管理番号);
        DbT4003YokaigoNinteiInterfaceEntity 情報entity = インターフェース情報.get(0);
        if (番号_1.equals(フェーズ番号)) {
            情報entity.setShinseiShubetsuCode(RString.EMPTY);
            情報entity.setShinseiYMD(FlexibleDate.EMPTY);
        }
        if (番号_2.equals(フェーズ番号)) {
            情報entity.setChosaItakuYMD(FlexibleDate.EMPTY);
            情報entity.setChosaItakusakiCode(JigyoshaNo.EMPTY);
            情報entity.setChosainCode(RString.EMPTY);
        }
        if (番号_3.equals(フェーズ番号)) {
            情報entity.setIryoKikanCode(RString.EMPTY);
            情報entity.setShujiiCode(RString.EMPTY);
            情報entity.setIkenshoIraiYMD(FlexibleDate.EMPTY);
        }
        if (番号_4.equals(フェーズ番号)) {
            情報entity.setChosaShuryoYMD(FlexibleDate.EMPTY);
        }
        if (番号_5.equals(フェーズ番号)) {
            情報entity.setIkenshoToriyoseYMD(FlexibleDate.EMPTY);
        }
        if (番号_6.equals(フェーズ番号)) {
            情報entity.setIchijiHanteiYMD(FlexibleDate.EMPTY);
            情報entity.setIchijiHanteiKekkaCode(RString.EMPTY);
            情報entity.setIchijiHanteiKekkaKasanCode(RString.EMPTY);
        }
        if (番号_8.equals(フェーズ番号)) {
            情報entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.EMPTY);
            情報entity.setShinsakaiYoteiYMD(FlexibleDate.EMPTY);
            情報entity.setGogitaiNo(0);
        }
        if (番号_9.equals(フェーズ番号)) {
            情報entity.setNijiHanteiYMD(FlexibleDate.EMPTY);
            情報entity.setNijiHanteiKekkaCode(RString.EMPTY);
            情報entity.setNinteiYukoKikanStart(FlexibleDate.EMPTY);
            情報entity.setNinteiYukoKikanEnd(FlexibleDate.EMPTY);
            情報entity.setShinsakaiIken(RString.EMPTY);
            情報entity.setYobiKubun4(RString.EMPTY);
        }
        情報entity.initializeMd5();
        情報entity.setState(EntityDataState.Modified);
        this.save主治医情報(情報entity);
    }

    private DbT4003YokaigoNinteiInterfaceEntity get主治医情報(RString 消し込みフラグ,
            RString 消込済, RString 進捗, RString 取込区分, List<YokaigoifUpdateRelateEntity> 情報_登録) {
        DbT4003YokaigoNinteiInterfaceEntity 主治医情報 = new DbT4003YokaigoNinteiInterfaceEntity();
        if (進捗.equals(取込区分)) {
            主治医情報 = this.get_Entity2(情報_登録);
        }
        if (!進捗.equals(取込区分) && 消込済.equals(消し込みフラグ)) {
            主治医情報 = this.get_Entity2(情報_登録);
        }
        if (!進捗.equals(取込区分) && 進捗.equals(消し込みフラグ)) {
            主治医情報 = this.get_Entity2(情報_登録);
        }
        return 主治医情報;
    }

    private void tourokuKoushin_2(RString フェーズ番号, YokaigoifUpdateMybitisParamter 申請書管理番号) {
        RString 番号_2 = new RString("2");
        RString 番号_3 = new RString("3");
        RString 番号_4 = new RString("4");
        RString 番号_5 = new RString("5");
        RString 番号_6 = new RString("6");
        RString 番号_8 = new RString("8");
        RString 番号_9 = new RString("9");
        List<DbT4003YokaigoNinteiInterfaceEntity> インターフェース情報 = this.getインターフェース情報(申請書管理番号);
        DbT4003YokaigoNinteiInterfaceEntity entity = インターフェース情報.get(0);
        if (番号_2.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が2 = this.get情報_番号が2(申請書管理番号);
            entity.setChosaItakuYMD(情報が2.get(0).get認定調査依頼年月日());
            entity.setChosaItakusakiCode(new JigyoshaNo(情報が2.get(0).get認定調査委託先コード().getColumnValue()));
            if (情報が2.get(0).get認定調査員コード() != null) {
                entity.setChosainCode(情報が2.get(0).get認定調査員コード().getColumnValue());
            }
        }
        if (番号_3.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が3 = this.get情報_番号が3(申請書管理番号);
            entity.setIryoKikanCode(情報が3.get(0).get主治医医療機関コード());
            entity.setShujiiCode(情報が3.get(0).get主治医コード());
            entity.setIkenshoIraiYMD(情報が3.get(0).get主治医意見書作成依頼年月日());
        }
        if (番号_4.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が4 = this.get情報_番号が4(申請書管理番号);
            entity.setChosaShuryoYMD(情報が4.get(0).get認定調査実施年月日());
            entity.setChosaItakusakiCode(new JigyoshaNo(情報が4.get(0).get認定調査委託先コード().getColumnValue()));
            entity.setChosainCode(情報が4.get(0).get認定調査員コード().getColumnValue());
        }
        if (番号_5.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が5 = this.get情報_番号が5(申請書管理番号);
            entity.setIryoKikanCode(情報が5.get(0).get主治医医療機関コード());
            entity.setIkenshoToriyoseYMD(情報が5.get(0).get主治医意見書受領年月日());
            entity.setChosainCode(情報が5.get(0).get主治医コード());
        }
        if (番号_6.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が6 = this.get情報_番号が6(申請書管理番号);
            entity.setIchijiHanteiYMD(情報が6.get(0).get要介護認定一次判定年月日());
            entity.setIchijiHanteiKekkaCode(情報が6.get(0).get要介護認定一次判定結果コード().getColumnValue());
            entity.setIchijiHanteiKekkaKasanCode(情報が6.get(0).get要介護認定一次判定結果コード_認知症加算().getColumnValue());
            if (!情報が6.get(0).get認知症高齢者の日常生活自立度コード().isEmpty()) {
                entity.setShogaiKoreiJiritsudo(情報が6.get(0).get認知症高齢者の日常生活自立度コード().getColumnValue());
            }
            if (!情報が6.get(0).get障害高齢者の日常生活自立度コード().isEmpty()) {
                entity.setNinchishoKoreiJiritsudo(情報が6.get(0).get障害高齢者の日常生活自立度コード().getColumnValue());
            }
        }
        if (番号_8.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が8 = this.get情報_番号が8(申請書管理番号);
            entity.setShinsakaiShiryoSakuseiYMD(情報が8.get(0).get介護認定審査会資料作成年月日());
            entity.setShinsakaiYoteiYMD(情報が8.get(0).get認定審査会予定年月日());
            entity.setGogitaiNo(情報が8.get(0).get合議体番号());
        }
        if (番号_9.equals(フェーズ番号)) {
            List<YokaigoifUpdateRelateEntity> 情報が9 = this.get情報_番号が9(申請書管理番号);
            entity.setNijiHanteiYMD(情報が9.get(0).get二次判定年月日());
            entity.setNijiHanteiKekkaCode(情報が9.get(0).get二次判定要介護状態区分コード().getColumnValue());
            entity.setNinteiYukoKikanStart(情報が9.get(0).get二次判定認定有効開始年月日());
            entity.setNinteiYukoKikanEnd(情報が9.get(0).get二次判定認定有効終了年月日());
            entity.setShinsakaiIken(情報が9.get(0).get介護認定審査会意見());
            if (!情報が9.get(0).get認定申請区分_法令_コード().isEmpty()) {
                entity.setYobiKubun4(情報が9.get(0).get認定申請区分_法令_コード().getColumnValue());
            }
        }
        entity.initializeMd5();
        entity.setState(EntityDataState.Modified);
        this.save主治医情報(entity);
    }

    @Transaction
    private boolean save主治医情報(DbT4003YokaigoNinteiInterfaceEntity 主治医情報) {
        requireNonNull(主治医情報, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報"));
        return 1 == dac.save(主治医情報);
    }

    private List<YokaigoifUpdateRelateEntity> get情報_登録(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_登録(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が9(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が9(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が8(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が8(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が6(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が6(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が5(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が5(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が4(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が4(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が3(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が3(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<YokaigoifUpdateRelateEntity> get情報_番号が2(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<YokaigoifUpdateRelateEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).get情報_番号が2(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private List<DbT4003YokaigoNinteiInterfaceEntity> getインターフェース情報(YokaigoifUpdateMybitisParamter 申請書管理番号) {
        List<DbT4003YokaigoNinteiInterfaceEntity> relateList
                = mapperProvider.create(IYokaigoifUpdateRelateMapper.class).getインターフェース情報(申請書管理番号);
        if (relateList == null || relateList.isEmpty()) {
            return null;
        }
        return relateList;
    }

    private DbT4003YokaigoNinteiInterfaceEntity get_Entity1(List<YokaigoifUpdateRelateEntity> 情報_登録, ShinseishoKanriNo 申請書管理番号) {
        DbT4003YokaigoNinteiInterfaceEntity 主治医情報 = new DbT4003YokaigoNinteiInterfaceEntity();
        if (情報_登録 == null || 情報_登録.isEmpty()) {
            return null;
        }
        YokaigoifUpdateRelateEntity entity = 情報_登録.get(0);
        主治医情報.setShinseishoKanriNo(申請書管理番号);
        主治医情報.setHihokenshaNo(new HihokenshaNo(entity.get被保険者番号()));
        if (RString.isNullOrEmpty(主治医情報.getRirekiNo())) {
            主治医情報.setRirekiNo(new RString("1"));
        } else {
            RString rirekiNo = new RString(Integer.parseInt(String.valueOf(主治医情報.getRirekiNo())) + 1);
            主治医情報.setRirekiNo(rirekiNo);
        }
        主治医情報.setTorikomiKubun(RString.EMPTY);
        主治医情報.setShinseiShubetsuCode(entity.get認定申請区分_申請時コード().getColumnValue());
        主治医情報.setTorisageKubunCode(RString.EMPTY);
        主治医情報.setShinseiYMD(entity.get認定申請年月日());
        if (entity.get主治医医療機関コード() != null) {
            主治医情報.setIryoKikanCode(entity.get主治医医療機関コード());
        }
        if (entity.get主治医コード() != null) {
            主治医情報.setShujiiCode(entity.get主治医コード());
        }
        主治医情報.setIkenshoIraiYMD(FlexibleDate.EMPTY);
        主治医情報.setIkenshoToriyoseYMD(FlexibleDate.EMPTY);
        主治医情報.setChosaItakuYMD(FlexibleDate.EMPTY);
        主治医情報.setChosaShuryoYMD(FlexibleDate.EMPTY);
        if (entity.get認定調査員コード() != null) {
            主治医情報.setChosainCode(entity.get認定調査員コード().getColumnValue());
        }
        if (entity.get認定調査委託先コード() != null) {
            主治医情報.setChosaItakusakiCode(new JigyoshaNo(entity.get認定調査委託先コード().value()));
        }
        主治医情報.setIchijiHanteiYMD(FlexibleDate.EMPTY);
        主治医情報.setIchijiHanteiKekkaCode(RString.EMPTY);
        主治医情報.setIchijiHanteiKekkaKasanCode(RString.EMPTY);
        主治医情報.setShinsakaiShiryoSakuseiYMD(FlexibleDate.EMPTY);
        主治医情報.setShinsakaiYoteiYMD(FlexibleDate.EMPTY);
        主治医情報.setNijiHanteiYMD(FlexibleDate.EMPTY);
        主治医情報.setNijiHanteiKekkaCode(RString.EMPTY);
        主治医情報.setNinteiYukoKikanStart(FlexibleDate.EMPTY);
        主治医情報.setNinteiYukoKikanEnd(FlexibleDate.EMPTY);
        主治医情報.setServiceHenkoRiyuCode(RString.EMPTY);
        主治医情報.setTokuteiShippeiCode(RString.EMPTY);
        主治医情報.setShogaiKoreiJiritsudo(RString.EMPTY);
        主治医情報.setNinchishoKoreiJiritsudo(RString.EMPTY);
        主治医情報.setShinsakaiIken(RString.EMPTY);
        Code コード99 = new Code("99A");
        Code コード02 = new Code("02A");
        Code コード06 = new Code("06A");
        Code コード09 = new Code("09A");
        Code コード09_B = new Code("09B");
        if (コード99.equals(entity.get厚労省IF識別コード())) {
            主治医情報.setVersionNo(new RString("001"));
        } else if (コード02.equals(entity.get厚労省IF識別コード())) {
            主治医情報.setVersionNo(new RString("101"));
        } else if (コード06.equals(entity.get厚労省IF識別コード())) {
            主治医情報.setVersionNo(new RString("201"));
        } else if (コード09.equals(entity.get厚労省IF識別コード())) {
            主治医情報.setVersionNo(new RString("301"));
        } else if (コード09_B.equals(entity.get厚労省IF識別コード())) {
            主治医情報.setVersionNo(new RString("401"));
        }
        主治医情報.setIchijiHanteiNaiyo(RString.EMPTY);
        主治医情報.setIchijiHanteiNaiyo2(RString.EMPTY);
        主治医情報.setKeshikomiFlag(new RString("0"));
        主治医情報.setYobiKomoku1(RString.EMPTY);
        主治医情報.setYobiKomoku2(RString.EMPTY);
        主治医情報.setYobiKomoku3(RString.EMPTY);
        主治医情報.setYobiKomoku4(RString.EMPTY);
        主治医情報.setYobiKomoku5(RString.EMPTY);
        主治医情報.setYobiKubun1(RString.EMPTY);
        主治医情報.setYobiKubun2(RString.EMPTY);
        主治医情報.setYobiKubun3(RString.EMPTY);
        主治医情報.setYobiKubun4(RString.EMPTY);
        主治医情報.setYobiKubun5(RString.EMPTY);
        主治医情報.setReserve(RString.EMPTY);
        return 主治医情報;
    }

    private DbT4003YokaigoNinteiInterfaceEntity get_Entity2(List<YokaigoifUpdateRelateEntity> 情報_登録) {
        DbT4003YokaigoNinteiInterfaceEntity 主治医情報 = new DbT4003YokaigoNinteiInterfaceEntity();
        主治医情報.setShinseiShubetsuCode(情報_登録.get(0).get認定申請区分_申請時コード().getColumnValue());
        主治医情報.setShinseiYMD(情報_登録.get(0).get認定申請年月日());
        主治医情報.setIryoKikanCode(RString.EMPTY);
        主治医情報.setShujiiCode(RString.EMPTY);
        主治医情報.setIkenshoIraiYMD(FlexibleDate.EMPTY);
        主治医情報.setIkenshoToriyoseYMD(FlexibleDate.EMPTY);
        主治医情報.setChosaItakuYMD(FlexibleDate.EMPTY);
        主治医情報.setChosaItakusakiCode(JigyoshaNo.EMPTY);
        主治医情報.setChosainCode(RString.EMPTY);
        主治医情報.setIchijiHanteiYMD(FlexibleDate.EMPTY);
        主治医情報.setIchijiHanteiKekkaCode(RString.EMPTY);
        主治医情報.setIchijiHanteiKekkaKasanCode(RString.EMPTY);
        主治医情報.setShinsakaiShiryoSakuseiYMD(FlexibleDate.EMPTY);
        主治医情報.setShinsakaiYoteiYMD(FlexibleDate.EMPTY);
        主治医情報.setNijiHanteiYMD(FlexibleDate.EMPTY);
        主治医情報.setNijiHanteiKekkaCode(RString.EMPTY);
        主治医情報.setNinteiYukoKikanStart(FlexibleDate.EMPTY);
        主治医情報.setNinteiYukoKikanEnd(FlexibleDate.EMPTY);
        主治医情報.setServiceHenkoRiyuCode(RString.EMPTY);
        主治医情報.setTokuteiShippeiCode(RString.EMPTY);
        主治医情報.setShogaiKoreiJiritsudo(RString.EMPTY);
        主治医情報.setNinchishoKoreiJiritsudo(RString.EMPTY);
        主治医情報.setShinsakaiIken(RString.EMPTY);
        return 主治医情報;
    }
}
