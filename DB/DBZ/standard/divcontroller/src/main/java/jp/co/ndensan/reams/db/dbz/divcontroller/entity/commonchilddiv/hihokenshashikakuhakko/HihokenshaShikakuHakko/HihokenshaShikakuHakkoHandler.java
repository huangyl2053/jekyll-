/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ServiceTypeListEntity;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshashoshikakushohakko.HihokenshashoShikakushoHakkoFinder;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「被保険者証・資格証」の状態を変更するクラスです。
 *
 *
 */
public class HihokenshaShikakuHakkoHandler {

    private final HihokenshaShikakuHakkoDiv div;
    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");
    private static final RString CODESHUBETSU_被保険者証交付事由 = new RString("0002");
    private static final RString CODESHUBETSU_資格者証交付事由 = new RString("0004");

    /**
     * コンストラクタです。
     *
     * @param div HihokenshaShikakuHakkoDiv
     */
    public HihokenshaShikakuHakkoHandler(HihokenshaShikakuHakkoDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 被保険者番号 被保険者番号
     * @param メニューID
     */
    public void initialize(HihokenshaNo 被保険者番号, RString メニューID) {

        HihokenshashoShikakushoHakkoFinder finder = HihokenshashoShikakushoHakkoFinder.createInstance();
        HihokenshoShikakushoHakkoEntity entity = finder.被保険者証資格証発行情報取得(被保険者番号, メニューID);

        if (null == entity) {
            entity = new HihokenshoShikakushoHakkoEntity();
        }
        // ヘッダエリア
        div.getYukoKigenInfo().getTxtYukoKigen().clearValue();
        div.getYukoKigenInfo().getTxtKofuDate().setValue(FlexibleDate.getNowDate());
        if (entity.get市町村コード() != null) {
            div.getYukoKigenInfo().getTxtHokensha().setValue(entity.get市町村コード().concat(RString.FULL_SPACE).concat(entity.get保険者名称()));
        }
        List<UzT0007CodeEntity> 交付事由List = new ArrayList<>();
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        if (MENUID_DBUMN12001.equals(メニューID)) {
            交付事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(CODESHUBETSU_被保険者証交付事由.toString()), FlexibleDate.getNowDate());
        } else if (MENUID_DBUMN12002.equals(メニューID)) {
            交付事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(CODESHUBETSU_資格者証交付事由.toString()), FlexibleDate.getNowDate());
        }

        for (UzT0007CodeEntity codeValueObject : 交付事由List) {
            dataSourceList.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード略称()));
        }
        div.getYukoKigenInfo().getDdlKofuJiyu().setDataSource(dataSourceList);

        if (entity.get要介護認定状態区分コード() != null) {
            div.getNinteiInfo().getTxtYokaigodo().setValue(YokaigoJotaiKubun09.toValue(entity.get要介護認定状態区分コード().getKey()).get名称());
        }
        if (entity.get認定年月日() != null) {
            div.getNinteiInfo().getTxtNinteiYMD().setValue(new RDate(entity.get認定年月日().toString()));
        }
        if (entity.get認定有効期間開始年月日() != null) {
            div.getNinteiInfo().getTxtNinteiYukoFromYMD().setValue(new RDate(entity.get認定有効期間開始年月日().toString()));
        }
        if (entity.get認定有効期間終了年月日() != null) {
            div.getNinteiInfo().getTxtNinteiYukoToYMD().setValue(new RDate(entity.get認定有効期間終了年月日().toString()));
        }
        if (entity.get受給申請年月日() != null) {
            div.getNinteiInfo().getTxtShinseiDate().setValue(entity.get受給申請年月日());
        }

        // 限度額タブ
        if (entity.get支給限度単位数() != null) {
            div.getTplGendoGaku().getTxtKubunShikyuGendoKijunGaku().setValue(new Decimal(entity.get支給限度単位数().toString()));
        }
        if (entity.get支給限度有効開始年月日() != null) {
            div.getTplGendoGaku().getTxtYukoFromYMD().setValue(new RDate(entity.get支給限度有効開始年月日().toString()));
        }
        if (entity.get支給限度有効終了年月日() != null) {
            div.getTplGendoGaku().getTxtYukoToYMD().setValue(new RDate(entity.get支給限度有効終了年月日().toString()));
        }
        List<dgShuruiShikyuGendoKijunGaku_Row> rowList = new ArrayList<>();
        if (entity.getServiceTypeListEntityList() != null) {
            for (ServiceTypeListEntity serviceTypeListEntity : entity.getServiceTypeListEntityList()) {
                dgShuruiShikyuGendoKijunGaku_Row row = new dgShuruiShikyuGendoKijunGaku_Row();
                if (serviceTypeListEntity.get限度額() != null) {
                    row.setGendoGaku(new RString(serviceTypeListEntity.get限度額().toString()));
                }
                row.setServiceShurui(serviceTypeListEntity.getサービス種類名称());
                rowList.add(row);
            }
            div.getTplGendoGaku().getShuruiShikyuGendoKijungaku().getDgShuruiShikyuGendoKijunGaku().setDataSource(rowList);
        }
        // 審査会意見タブ
        if (entity.get介護認定審査会意見() != null) {
            div.getTplShinsakaiIken().getTxtShinsakaiIken().setValue(entity.get介護認定審査会意見());
        }

        // 給付制限タブ
        if (entity.get給付制限内容１() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenNaiyo1().setValue(entity.get給付制限内容１());
        }
        if (entity.get給付制限内容２() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenNaiyo2().setValue(entity.get給付制限内容２());
        }
        if (entity.get給付制限内容３() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenNaiyo3().setValue(entity.get給付制限内容３());
        }
        if (entity.get制限期間開始１() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenKikan1().setFromValue(new RDate(entity.get制限期間開始１().toString()));
        }
        if (entity.get制限期間開始２() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenKikan2().setFromValue(new RDate(entity.get制限期間開始２().toString()));
        }
        if (entity.get制限期間開始３() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenKikan3().setFromValue(new RDate(entity.get制限期間開始３().toString()));
        }
        if (entity.get制限期間終了１() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenKikan1().setToValue(new RDate(entity.get制限期間終了１().toString()));
        }
        if (entity.get制限期間終了２() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenKikan2().setToValue(new RDate(entity.get制限期間終了２().toString()));
        }
        if (entity.get制限期間終了３() != null) {
            div.getTplKyufuSeigen().getTxtKyufuSeigenKikan3().setToValue(new RDate(entity.get制限期間終了３().toString()));
        }

        // 支援事業者タブ
        div.getTplShienJigyosha().getTxtJigyosha1().setValue(entity.get事業者１());
        div.getTplShienJigyosha().getTxtJigyosha2().setValue(entity.get事業者２());
        div.getTplShienJigyosha().getTxtJigyosha3().setValue(entity.get事業者３());
        div.getTplShienJigyosha().getTxtTodokedeYMD1().setValue(entity.get届出年月日１());
        div.getTplShienJigyosha().getTxtTodokedeYMD2().setValue(entity.get届出年月日２());
        div.getTplShienJigyosha().getTxtTodokedeYMD3().setValue(entity.get届出年月日３());
        div.getTplShienJigyosha().getTxtTekiyoStYMD1().setValue(entity.get適用開始年月日１());
        div.getTplShienJigyosha().getTxtTekiyoStYMD2().setValue(entity.get適用開始年月日２());
        div.getTplShienJigyosha().getTxtTekiyoStYMD3().setValue(entity.get適用開始年月日３());

        // 施設入退所タブ
        div.getTplShisetsuNyutaisho().getTxtNyushoShisetsu1().setValue(entity.get入所施設１());
        div.getTplShisetsuNyutaisho().getTxtNyushoShisetsu2().setValue(entity.get入所施設２());
        div.getTplShisetsuNyutaisho().getTxtNyushoShisetsu3().setValue(entity.get入所施設３());
        div.getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate1().setValue(entity.get入所年月日１());
        div.getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate2().setValue(entity.get入所年月日２());
        div.getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate3().setValue(entity.get入所年月日３());
        div.getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate1().setValue(entity.get退所年月日１());
        div.getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate2().setValue(entity.get退所年月日２());
        div.getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate3().setValue(entity.get退所年月日３());
    }
}
