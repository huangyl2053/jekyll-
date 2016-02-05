/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ServiceTypeListEntity;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshashoShikakushoHakko.HihokenshashoShikakushoHakkoFinder;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「住所地特例履歴」の状態を変更するクラスです。
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

        // ヘッダエリア
        div.getYukoKigenInfo().getTxtYukoKigen().clearValue();
        div.getYukoKigenInfo().getTxtKofuDate().setValue(FlexibleDate.getNowDate());
        div.getYukoKigenInfo().getTxtHokensha().setValue(entity.get市町村コード().concat(RString.FULL_SPACE).concat(entity.get保険者名称()));

        List<UzT0007CodeEntity> 交付事由List = new ArrayList<>();
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        //dataSourceList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        if (MENUID_DBUMN12001.equals(メニューID)) {
            交付事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(CODESHUBETSU_被保険者証交付事由.toString()));
        } else if (MENUID_DBUMN12002.equals(メニューID)) {
            交付事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(CODESHUBETSU_資格者証交付事由.toString()));
        }

        for (UzT0007CodeEntity codeValueObject : 交付事由List) {
            dataSourceList.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード略称()));
        }
        div.getYukoKigenInfo().getDdlKofuJiyu().setDataSource(dataSourceList);

        // TODO
        //div.getNinteiInfo().getTxtYokaigodo().setValue(YokaigoJotaiKubun09.toValue(entity.get要介護認定状態区分コード()).get名称());
        div.getNinteiInfo().getTxtNinteiYMD().setValue(entity.get認定年月日().toRDate());
        div.getNinteiInfo().getTxtNinteiYukoFromYMD().setValue(entity.get認定有効期間開始年月日().toRDate());
        div.getNinteiInfo().getTxtNinteiYukoToYMD().setValue(entity.get認定有効期間終了年月日().toRDate());
        div.getNinteiInfo().getTxtShinseiDate().setValue(entity.get受給申請年月日());

        // 限度額タブ
        div.getTplGendoGaku().getTxtKubunShikyuGendoKijunGaku().setValue(Decimal.valueOf(Integer.valueOf(entity.get支給限度単位数().toString())));
        div.getTplGendoGaku().getTxtYukoFromYMD().setValue(entity.get支給限度有効開始年月日().toRDate());
        div.getTplGendoGaku().getTxtYukoToYMD().setValue(entity.get支給限度有効終了年月日().toRDate());
        List<dgShuruiShikyuGendoKijunGaku_Row> rowList = new ArrayList<>();
        for (ServiceTypeListEntity serviceTypeListEntity : entity.getServiceTypeListEntityList()) {
            dgShuruiShikyuGendoKijunGaku_Row row = new dgShuruiShikyuGendoKijunGaku_Row();
            //TODO row.setGendoGaku(serviceTypeListEntity.get限度額());
            row.setServiceShurui(serviceTypeListEntity.getサービス種類名称());
            rowList.add(row);
        }
        div.getTplGendoGaku().getShuruiShikyuGendoKijungaku().getDgShuruiShikyuGendoKijunGaku().setDataSource(rowList);

        // 審査会意見タブ
        div.getTplShinsakaiIken().getTxtShinsakaiIken().setValue(entity.get介護認定審査会意見());

        // 給付制限タブ
        div.getTplKyufuSeigen().getTxtKyufuSeigenNaiyo1().setValue(entity.get給付制限内容１());
        div.getTplKyufuSeigen().getTxtKyufuSeigenNaiyo2().setValue(entity.get給付制限内容２());
        div.getTplKyufuSeigen().getTxtKyufuSeigenNaiyo3().setValue(entity.get給付制限内容３());
        div.getTplKyufuSeigen().getTxtKyufuSeigenKikan1().setFromValue(entity.get制限期間開始１().toRDate());
        div.getTplKyufuSeigen().getTxtKyufuSeigenKikan2().setFromValue(entity.get制限期間開始２().toRDate());
        div.getTplKyufuSeigen().getTxtKyufuSeigenKikan3().setFromValue(entity.get制限期間開始３().toRDate());
        div.getTplKyufuSeigen().getTxtKyufuSeigenKikan1().setToValue(entity.get制限期間終了１().toRDate());
        div.getTplKyufuSeigen().getTxtKyufuSeigenKikan2().setToValue(entity.get制限期間終了２().toRDate());
        div.getTplKyufuSeigen().getTxtKyufuSeigenKikan3().setToValue(entity.get制限期間終了３().toRDate());

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
