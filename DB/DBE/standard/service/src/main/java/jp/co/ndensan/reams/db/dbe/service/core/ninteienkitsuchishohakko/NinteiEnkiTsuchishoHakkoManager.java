/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteienkitsuchishohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteienkitsuchishohakko.DgHakkotaishoshaRow;
import jp.co.ndensan.reams.db.dbe.business.core.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteienkitsuchishohakko.INinteiEnkiTsuchishoHakkoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoDbT5101Child;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定延期通知発行を管理するクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public class NinteiEnkiTsuchishoHakkoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiEnkiTsuchishoHakkoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 認定延期通知発行のビジネスを生成します。
     *
     * @return 認定延期通知発行のビジネス
     */
    public static NinteiEnkiTsuchishoHakkoManager createInstance() {
        return InstanceProvider.create(NinteiEnkiTsuchishoHakkoManager.class);
    }

    /**
     * 発行対象者一覧情報を取得します。
     *
     * @param 経過日数 経過日数
     * @param 申請区分KeyList 申請区分KeyList
     * @param 発行有無KeyList 発行有無KeyList
     * @param みなし２号Key みなし２号Key
     * @param 処理見込み日From 処理見込み日From
     * @param 処理見込み日To 処理見込み日To
     * @param 延期の理由 延期の理由
     * @param 認定調査KeyList 認定調査KeyList
     * @param 市町村コード 市町村コード
     * @param 意見書受領KeyList 意見書受領KeyList
     * @param 一次判定KeyList 一次判定KeyList
     * @param 審査会割付KeyList 審査会割付KeyList
     *
     * @return 居宅サービス計画情報
     */
    @Transaction
    public List<NinteiEnkiTsuchishoHakkoBusiness> get発行対象者一覧情報(int 経過日数, List<RString> 申請区分KeyList, List<RString> 発行有無KeyList,
            RString みなし２号Key, RDate 処理見込み日From, RDate 処理見込み日To, RString 延期の理由, LasdecCode 市町村コード,
            List<RString> 認定調査KeyList, List<RString> 意見書受領KeyList, List<RString> 一次判定KeyList, List<RString> 審査会割付KeyList) {
        ShichosonSecurityJoho 市町村セキュリティ情報
                = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        NinteiEnkiTsuchishoHakkoParameter parameter = new NinteiEnkiTsuchishoHakkoParameter(経過日数, 申請区分KeyList,
                発行有無KeyList, みなし２号Key, 処理見込み日From, 処理見込み日To, 延期の理由, 市町村コード,
                認定調査KeyList, 意見書受領KeyList, 一次判定KeyList, 審査会割付KeyList);
        INinteiEnkiTsuchishoHakkoMapper mapper = mapperProvider.create(INinteiEnkiTsuchishoHakkoMapper.class);
        if (null == 市町村セキュリティ情報 || KaigoDonyuKubun.未導入.code().equals(市町村セキュリティ情報.get介護導入区分().code())) {
            return new ArrayList<>();
        }
        List<NinteiEnkiTsuchishoHakkoEntity> entityList = new ArrayList<>();
        if (DonyuKeitaiCode.事務広域.equals(市町村セキュリティ情報.get導入形態コード())
                || DonyuKeitaiCode.事務構成市町村.equals(市町村セキュリティ情報.get導入形態コード())) {
            parameter.set単一(false);
            entityList = mapper.get発行対象者一覧情報_広域(parameter);
        } else if (DonyuKeitaiCode.事務単一.equals(市町村セキュリティ情報.get導入形態コード())) {
            parameter.set単一(true);
            entityList = mapper.get発行対象者一覧情報_単一(parameter);
        }
        List<NinteiEnkiTsuchishoHakkoBusiness> 居宅サービス計画情報 = new ArrayList<>();
        for (NinteiEnkiTsuchishoHakkoEntity entity : entityList) {
            居宅サービス計画情報.add(new NinteiEnkiTsuchishoHakkoBusiness(entity));
        }
        return 居宅サービス計画情報;
    }

    /**
     * 要介護認定申請情報情報を取得します。
     *
     * @param 申請書管理番号List 申請書管理番号List
     *
     * @return 要介護認定申請情報List
     */
    @Transaction
    public List<NinteiShinseiJohoDbT5101Child> get要介護認定申請情報(List<RString> 申請書管理番号List) {
        List<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報List = new ArrayList<>();
        DbT5101NinteiShinseiJohoDac dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        List<DbT5101NinteiShinseiJohoEntity> entityList = dac.selectByZenkaiShinseishoKanriNoList(申請書管理番号List);
        for (DbT5101NinteiShinseiJohoEntity entity : entityList) {
            要介護認定申請情報List.add(new NinteiShinseiJohoDbT5101Child(entity));
        }
        return 要介護認定申請情報List;
    }

    /**
     * 更新処理します。
     *
     * @param 要介護認定申請情報List 要介護認定申請情報List
     * @param rowEntityList 選択発行対象者一覧情報
     *
     */
    @Transaction
    public void 更新処理(List<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報List, List<DgHakkotaishoshaRow> rowEntityList) {
        DbT5101NinteiShinseiJohoDac dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        for (NinteiShinseiJohoDbT5101Child 要介護認定申請情報 : 要介護認定申請情報List) {
            DbT5101NinteiShinseiJohoEntity entity = get更新要介護認定申請情報(要介護認定申請情報, rowEntityList);
            if (entity != null) {
                dac.save(entity);
            }
        }
    }

    private DbT5101NinteiShinseiJohoEntity get更新要介護認定申請情報(NinteiShinseiJohoDbT5101Child 要介護認定申請情報, List<DgHakkotaishoshaRow> rowEntityList) {
        for (DgHakkotaishoshaRow row : rowEntityList) {
            if (要介護認定申請情報.get申請書管理番号().getColumnValue().equals(row.get申請書管理番号())) {
//                DbT4101NinteiShinseiJohoEntity dbT4101entity = 要介護認定申請情報.toEntity();
                DbT5101NinteiShinseiJohoEntity entity = 要介護認定申請情報.toEntity();
                entity.setEnkiKetteiYMD(rDateToFlexibleDate(row.get延期決定日()));
                entity.setEnkiRiyu(row.get延期理由());
                entity.setEnkiTsuchiHakkoYMD(rDateToFlexibleDate(row.get通知書発行日()));
                entity.setEnkiTsuchiHakkoKaisu(要介護認定申請情報.get延期通知発行回数() + 1);
                entity.setEnkiMikomiKaishiYMD(rDateToFlexibleDate(row.get見込処理期間_開始()));
                entity.setEnkiMikomiShuryoYMD(rDateToFlexibleDate(row.get見込処理期間_終了()));
                entity.setState(EntityDataState.Modified);
                return entity;
            }
        }
        return null;
    }

    private FlexibleDate rDateToFlexibleDate(RDate date) {
        if (null == date) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date.toDateString());
    }

    /**
     * 延期の理由を取得します。
     *
     *
     * @return 延期の理由
     */
    @Transaction
    public List<RString> get延期の理由() {
        List<UzT0007CodeEntity> entityList
                = CodeMaster.getCodeRireki(SubGyomuCode.DBE認定支援, DBECodeShubetsu.延期理由.getコード());
        List<RString> 延期の理由 = new ArrayList<>();
        延期の理由.add(RString.EMPTY);
        for (UzT0007CodeEntity entity : entityList) {
            延期の理由.add(entity.getコード略称());
        }
        return 延期の理由;
    }

}
