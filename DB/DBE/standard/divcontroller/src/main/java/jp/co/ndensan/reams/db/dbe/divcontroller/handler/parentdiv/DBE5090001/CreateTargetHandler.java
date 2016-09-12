/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CreateTargetBusiness;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * センター送信データ出力の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateTargetHandler {

    private final CreateTargetDiv div;
    private static final RString キー_0 = new RString("key0");

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
        div.getRdoShinseiNintei().setSelectedKey(キー_0);
        div.getTxtShinseiYMD().setDisabled(false);
        div.getNinteiYMD().setDisabled(true);
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
        div.getRdoShinseiNintei().setSelectedKey(キー_0);
        div.getTxtShinseiYMD().setDisabled(false);
        div.getTxtShinseiYMD().clearFromValue();
        div.getTxtShinseiYMD().clearToValue();
        div.getNinteiYMD().setDisabled(true);
        div.getNinteiYMD().clearFromValue();
        div.getNinteiYMD().clearToValue();
        div.getRdoSyutsuryoku().setSelectedKey(キー_0);
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 申請日認定日処理します。
     *
     */
    public void onChange_btnChange() {
        if (キー_0.equals(div.getRdoShinseiNintei().getSelectedKey())) {
            div.getTxtShinseiYMD().setDisabled(false);
            div.getNinteiYMD().setDisabled(true);
            div.getNinteiYMD().clearFromValue();
            div.getNinteiYMD().clearToValue();
        } else {
            div.getTxtShinseiYMD().setDisabled(true);
            div.getTxtShinseiYMD().clearFromValue();
            div.getTxtShinseiYMD().clearToValue();
            div.getNinteiYMD().setDisabled(false);
        }
    }

    /**
     * 対象者一覧情報の検索設定します。
     *
     * @param business 対象者一覧情報
     */
    public void onClick_btnKensaku(List<CreateTargetBusiness> business) {
        List<dgCreateTargetSummary_Row> rowList = new ArrayList<>();
        for (CreateTargetBusiness list : business) {
            dgCreateTargetSummary_Row row = new dgCreateTargetSummary_Row();
            row.setHokenshano(list.get証記載保険者番号());
            row.setHokensha(list.get市町村名称());
            row.setHihokenshaBango(list.get被保険者番号());
            row.setHihokenshaShimei(list.get被保険者氏名().value());
            row.setHihokenshaShimeiKana(list.get被保険者氏名カナ().value());
            row.setSex(Seibetsu.toValue(list.get性別().value()).get名称());
            row.getBirthDate().setValue(getNull(list.get生年月日()));
            row.getNinteiShinseibi().setValue(getNull(list.get認定申請年月日()));
            row.setShinseiKubunShin(NinteiShinseiShinseijiKubunCode.toValue(list.get認定申請区分_申請時コード().value()).get名称());
            row.setShinseiKubunHo(NinteiShinseiHoreiCode.toValue(list.get認定申請区分_法令コード().value()).get名称());
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
            row.getYukoKikanstart().setValue(getNull(list.get認定有効開始年月日()));
            row.getYukokikanend().setValue(getNull(list.get認定有効終了年月日()));
            row.getDataShutsuryoku().setValue(getNull(list.get送信年月日()));
            row.setShinseishokanrino(list.get申請書管理番号());
            rowList.add(row);
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                    new RString("申請書管理番号"), list.get申請書管理番号()));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0002"), new RString("証記載保険者番号"), list.get証記載保険者番号()));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), list.get被保険者番号()));
            AccessLogger.log(AccessLogType.照会, personalData);
        }
        div.getDgCreateTargetSummary().setDataSource(rowList);
    }

    private RDate getNull(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RDate(年月日.toString());
        }
        return null;
    }
}
