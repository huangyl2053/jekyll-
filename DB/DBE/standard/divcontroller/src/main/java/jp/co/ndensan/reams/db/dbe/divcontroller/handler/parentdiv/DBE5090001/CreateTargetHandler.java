/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CreateTargetBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.createtarget.CreateTargetMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.CreateTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.dgCreateTargetSummary_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * センター送信データ出力の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateTargetHandler {

    private final CreateTargetDiv div;
    private static final RString キー_0 = new RString("0");
    private static final RString キー_1 = new RString("1");
    private static final RString 基準日_認定申請日キー = new RString("0");
    private static final RString 基準日_二次判定日キー = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 個人依頼内容更新Div
     */
    public CreateTargetHandler(CreateTargetDiv div) {
        this.div = div;
    }

    /**
     * 個人依頼内容更新の初期化設定します。
     *
     */
    public void onLoad() {
        div.getRdoShinseiNintei().setSelectedKey(基準日_二次判定日キー);
        div.getRdoSyutsuryoku().setSelectedKey(キー_0);
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 個人依頼内容更新のクリア処理します。
     *
     */
    public void onClick_btnClear() {
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtKijunYMD().clearFromValue();
        div.getTxtKijunYMD().clearToValue();
        onLoad();
    }

    /**
     * 申請日認定日処理します。
     *
     */
    public void onChange_btnChange() {
        div.getTxtKijunYMD().clearFromValue();
        div.getTxtKijunYMD().clearToValue();
    }

    /**
     * 対象者一覧情報の検索設定します。
     *
     * @param business 対象者一覧情報
     */
    public void onClick_btnKensaku(SearchResult<CreateTargetBusiness> business) {
        List<dgCreateTargetSummary_Row> rowList = new ArrayList<>();
        for (CreateTargetBusiness list : business.records()) {
            dgCreateTargetSummary_Row row = new dgCreateTargetSummary_Row();
            row.setHokenshano(list.get証記載保険者番号());
            row.setHokensha(list.get市町村名称());
            row.setHihokenshaBango(list.get被保険者番号());
            row.setHihokenshaShimei(list.get被保険者氏名().value());
            row.setHihokenshaShimeiKana(list.get被保険者氏名カナ().value());
            row.setSex(Seibetsu.toValue(list.get性別().value()).get名称());
            row.getBirthDate().setValue(getNull(list.get生年月日()));
            row.setKoroshoIfShikibetsuCode(list.get厚労省IF識別コード().value());
            row.getNinteiShinseibi().setValue(getNull(list.get認定申請年月日()));
            row.setShinseiKubunShin(NinteiShinseiShinseijiKubunCode.toValue(list.get認定申請区分_申請時コード().value()).get名称());
            if (list.get認定申請区分_法令コード() != null && !list.get認定申請区分_法令コード().value().isEmpty()) {
                row.setShinseiKubunHo(NinteiShinseiHoreiCode.toValue(list.get認定申請区分_法令コード().value()).get名称());
            }
            row.getNijiHanteiBi().setValue(getNull(list.get二次判定日()));
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(list.get厚労省IF識別コード().value())) {
                row.setNijiHanteiKekka(YokaigoJotaiKubun99.toValue(list.get状態区分コード()).get名称());
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(list.get厚労省IF識別コード().value())) {
                row.setNijiHanteiKekka(YokaigoJotaiKubun02.toValue(list.get状態区分コード()).get名称());
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(list.get厚労省IF識別コード().value())) {
                row.setNijiHanteiKekka(YokaigoJotaiKubun06.toValue(list.get状態区分コード()).get名称());
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(list.get厚労省IF識別コード().value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(list.get厚労省IF識別コード().value())) {
                row.setNijiHanteiKekka(YokaigoJotaiKubun09.toValue(list.get状態区分コード()).get名称());
            }
            row.setNinteiYukoKikan(new RString(list.get認定有効期間()));
            row.getSortNinteiYukoKikan().setValue(new Decimal(list.get認定有効期間()));
            row.getYukoKikanstart().setValue(getNull(list.get認定有効開始年月日()));
            row.getYukokikanend().setValue(getNull(list.get認定有効終了年月日()));
            row.getDataShutsuryoku().setValue(getNull(list.get送信年月日()));
            row.setShinseishokanrino(list.get申請書管理番号());
            rowList.add(row);
        }
        div.getDgCreateTargetSummary().getGridSetting().setLimitRowCount(Integer.parseInt(div.getTxtMaxKensu().getValue().toString()));
        div.getDgCreateTargetSummary().getGridSetting().setSelectedRowCount(business.totalCount());
        div.getDgCreateTargetSummary().setDataSource(rowList);
    }

    private RDate getNull(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RDate(年月日.toString());
        }
        return null;
    }

    /**
     * CSV出力した後にファイル作成日を更新します。
     *
     * @param ファイル作成日 ファイル作成日
     */
    public void updateファイル作成日(RDate ファイル作成日) {

        List<dgCreateTargetSummary_Row> rows = new ArrayList<>();
        for (dgCreateTargetSummary_Row row : div.getDgCreateTargetSummary().getDataSource()) {
            if (row.getSelected()) {
                row.getDataShutsuryoku().setValue(ファイル作成日);
            }
            rows.add(row);
        }
        div.getDgCreateTargetSummary().setDataSource(rows);
    }

    /**
     * パラメータを作成して返します。
     *
     * @return CreateTargetMapperParameter
     */
    public CreateTargetMapperParameter createParam() {
        RString データ出力 = キー_1;
        FlexibleDate 申請_開始日 = FlexibleDate.EMPTY;
        FlexibleDate 申請_終了日 = FlexibleDate.EMPTY;
        FlexibleDate 認定_開始日 = FlexibleDate.EMPTY;
        FlexibleDate 認定_終了日 = FlexibleDate.EMPTY;
        if (キー_0.equals(div.getRdoSyutsuryoku().getSelectedKey())) {
            データ出力 = キー_0;
        }
        if (基準日_認定申請日キー.equals(div.getRdoShinseiNintei().getSelectedKey())) {
            申請_開始日 = new FlexibleDate(div.getTxtKijunYMD().getFromValue().toDateString());
            申請_終了日 = new FlexibleDate(div.getTxtKijunYMD().getToValue().toDateString());
        } else if (基準日_二次判定日キー.equals(div.getRdoShinseiNintei().getSelectedKey())) {
            認定_開始日 = new FlexibleDate(div.getTxtKijunYMD().getFromValue().toDateString());
            認定_終了日 = new FlexibleDate(div.getTxtKijunYMD().getToValue().toDateString());
        }
        return CreateTargetMapperParameter.createParam(データ出力, 申請_開始日, 申請_終了日,
                認定_開始日, 認定_終了日, Integer.parseInt(div.getTxtMaxKensu().getValue().toString()),
                div.getTxtHihokenshaNo().getValue());
    }
}
