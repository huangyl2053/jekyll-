/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseitorokuuketsuke.NinteiShinseiTorokuUketsukeBusiness;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5120001.NinteiShinseiTorokuUketsukeParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5120001.NinteiShinseiTorokuUketsukeEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseitorokuuketsuke.INinteiShinseiTorokuUketsukeMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosajokyo.NinteiChosaJokyoDataPassEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請受付表示情報を取得する
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeManager {

    private final MapperProvider mapperProvider;

    NinteiShinseiTorokuUketsukeManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    NinteiShinseiTorokuUketsukeManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * NinteiShinseiTorokuUketsukeManagerのインスタンス化
     *
     * @return NinteiShinseiTorokuUketsukeManager
     */
    public static NinteiShinseiTorokuUketsukeManager createInstance() {
        return InstanceProvider.create(NinteiShinseiTorokuUketsukeManager.class);
    }

    /**
     * 初期化情報情報の検索
     *
     * @param param NinteiShinseiTorokuUketsukeParameter
     * @return NinteiShinseiTorokuUketsukeBusiness
     */
    @Transaction
    public NinteiShinseiTorokuUketsukeBusiness get初期化情報(NinteiShinseiTorokuUketsukeParameter param) {

        INinteiShinseiTorokuUketsukeMapper mapper = mapperProvider.create(INinteiShinseiTorokuUketsukeMapper.class);

        NinteiShinseiTorokuUketsukeEntity resultEntity
                = mapper.get初期化情報(param);
        if (resultEntity != null) {
            return new NinteiShinseiTorokuUketsukeBusiness(resultEntity);
        } else {
            return null;
        }
    }

    /**
     *
     * @param param NinteiShinseiTorokuUketsukeParameter
     * @return 初期化情報_申請区分変更サービス変更
     */
    @Transaction
    public NinteiShinseiTorokuUketsukeBusiness get初期化情報_申請区分変更サービス変更修正(NinteiShinseiTorokuUketsukeParameter param) {

        INinteiShinseiTorokuUketsukeMapper mapper = mapperProvider.create(INinteiShinseiTorokuUketsukeMapper.class);

        NinteiShinseiTorokuUketsukeEntity resultEntity
                = mapper.get初期化情報_申請区分変更サービス変更修正(param);
        if (resultEntity != null) {
            return new NinteiShinseiTorokuUketsukeBusiness(resultEntity);
        } else {
            return null;
        }
    }

    /**
     * 初期化情報情報の検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<NinteiChosaJokyoDataPass>
     */
    @Transaction
    public List<NinteiChosaJokyoDataPass> get履歴情報(HihokenshaNo 被保険者番号) {

        INinteiShinseiTorokuUketsukeMapper mapper = mapperProvider.create(INinteiShinseiTorokuUketsukeMapper.class);

        List<NinteiChosaJokyoDataPassEntity> result = mapper.get履歴情報(被保険者番号);

        List<NinteiChosaJokyoDataPass> returnList = new ArrayList<>();
        for (NinteiChosaJokyoDataPassEntity entity : result) {
            NinteiChosaJokyoDataPass dataPass = new NinteiChosaJokyoDataPass();
            dataPass.set主治医コード(entity.get主治医コード());
            dataPass.set主治医住所(entity.get主治医住所());
            dataPass.set主治医医療機関コード(entity.get主治医医療機関コード());
            dataPass.set主治医意見書作成依頼年月日(new RDate(entity.get主治医意見書作成依頼年月日().getYearValue(),
                    entity.get主治医意見書作成依頼年月日().getMonthValue(), entity.get主治医意見書作成依頼年月日().getDayValue()));
            dataPass.set主治医意見書登録予定年月日(new RDate(entity.get主治医意見書登録予定年月日().getYearValue(),
                    entity.get主治医意見書登録予定年月日().getMonthValue(), entity.get主治医意見書登録予定年月日().getDayValue()));
            dataPass.set主治医意見書記入年月日(new RDate(entity.get主治医意見書記入年月日().getYearValue(),
                    entity.get主治医意見書記入年月日().getMonthValue(), entity.get主治医意見書記入年月日().getDayValue()));
            dataPass.set主治医氏名(entity.get主治医氏名());
            dataPass.set主治医郵便番号(entity.get主治医郵便番号());
            dataPass.set主治医電話番号(entity.get主治医電話番号());
            dataPass.set事業者名称(entity.get事業者名称());
            dataPass.set二次判定年月日(new RDate(entity.get二次判定年月日().getYearValue(),
                    entity.get二次判定年月日().getMonthValue(), entity.get二次判定年月日().getDayValue()));
            dataPass.set二次判定要介護状態区分コード(entity.get二次判定要介護状態区分コード());
            dataPass.set二次判定認定有効期間(entity.get二次判定認定有効期間());
            dataPass.set二次判定認定有効終了年月日(entity.get二次判定認定有効終了年月日());
            dataPass.set二次判定認定有効開始年月日(entity.get二次判定認定有効開始年月日());
            dataPass.set介護認定審査会資料作成年月日(new RDate(entity.get介護認定審査会資料作成年月日().getYearValue(),
                    entity.get介護認定審査会資料作成年月日().getMonthValue(), entity.get介護認定審査会資料作成年月日().getDayValue()));
            dataPass.set医療機関名称(entity.get医療機関名称());
            dataPass.set厚労省IF識別コード(entity.get厚労省IF識別コード());
            dataPass.set市町村コード(entity.get市町村コード());
            dataPass.set延期通知発行回数(entity.get延期通知発行回数());
            dataPass.set延期通知発行年月日(new RDate(entity.get延期通知発行年月日().getYearValue(),
                    entity.get延期通知発行年月日().getMonthValue(), entity.get延期通知発行年月日().getDayValue()));
            dataPass.set指定医フラグ(entity.is指定医フラグ());
            dataPass.set申請書管理番号(entity.get申請書管理番号());
            dataPass.set要介護認定一次判定年月日(new RDate(entity.get要介護認定一次判定年月日().getYearValue(),
                    entity.get要介護認定一次判定年月日().getMonthValue(), entity.get要介護認定一次判定年月日().getDayValue()));
            dataPass.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
            dataPass.set要介護認定一次判定結果コード_認知症加算(entity.get要介護認定一次判定結果コード_認知症加算());
            dataPass.set訪問調査先住所(entity.get訪問調査先住所());
            dataPass.set訪問調査先名称(entity.get訪問調査先名称());
            dataPass.set訪問調査先郵便番号(entity.get訪問調査先郵便番号());
            dataPass.set訪問調査先電話番号(entity.get訪問調査先電話番号());
            dataPass.set認定住所(entity.get認定住所());
            dataPass.set認定審査会予定年月日(new RDate(entity.get認定審査会予定年月日().getYearValue(),
                    entity.get認定審査会予定年月日().getMonthValue(), entity.get認定審査会予定年月日().getDayValue()));
            dataPass.set認定調査予定年月日(new RDate(entity.get認定調査予定年月日().getYearValue(),
                    entity.get認定調査予定年月日().getMonthValue(), entity.get認定調査予定年月日().getDayValue()));
            dataPass.set認定調査依頼年月日(new RDate(entity.get認定調査依頼年月日().getYearValue(),
                    entity.get認定調査依頼年月日().getMonthValue(), entity.get認定調査依頼年月日().getDayValue()));
            dataPass.set認定調査員コード(entity.get認定調査員コード());
            dataPass.set認定調査委託先コード(entity.get認定調査委託先コード());
            dataPass.set認定調査実施年月日(new RDate(entity.get認定調査実施年月日().getYearValue(),
                    entity.get認定調査実施年月日().getMonthValue(), entity.get認定調査実施年月日().getDayValue()));
            dataPass.set認定郵便番号(entity.get認定郵便番号());
            dataPass.set認定電話番号(entity.get認定電話番号());
            dataPass.set調査員氏名(entity.get調査員氏名());
            dataPass.set調査委託区分(entity.get調査委託区分());

            returnList.add(dataPass);
        }
        return returnList;
    }
}
