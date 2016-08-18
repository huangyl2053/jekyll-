/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishiencentersoshin.NinteiShienCenterSoshinData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.NinteiShienCenterSoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * センター送信準備のHandlerクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public class NinteiShienCenterSoshinHandler {

    private static final Code A_99 = new Code("99A");
    private static final Code A_02 = new Code("02A");
    private static final Code A_06 = new Code("06A");
    private static final Code A_09 = new Code("09A");
    private static final Code B_09 = new Code("09B");
    private final NinteiShienCenterSoshinDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShienCenterSoshinDiv
     */
    public NinteiShienCenterSoshinHandler(NinteiShienCenterSoshinDiv div) {
        this.div = div;
    }

    /**
     * 初期化の項目設定処理です。
     */
    public void onLoad() {
        div.getRadDataShutsuryoku().setSelectedKey(new RString("key0"));
        RDate システム日付 = RDate.getNowDate();
        div.getTxtNijiHanteibi().clearFromValue();
        div.getTxtNijiHanteibi().setToValue(システム日付);
        RString 最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, システム日付, SubGyomuCode.DBU介護統計報告);
        RString 最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, システム日付, SubGyomuCode.DBU介護統計報告);
        if (!RString.isNullOrEmpty(最大取得件数)) {
            div.getTxtDispMax().setValue(new Decimal(最大取得件数.toString()));
        }
        if (!RString.isNullOrEmpty(最大取得件数上限)) {
            div.getTxtDispMax().setMaxValue(new Decimal(最大取得件数上限.toString()));
        }
    }

    /**
     * 検索条件入力項目のクリア処理です。
     */
    public void onClick_BtnClear() {
        div.getRadDataShutsuryoku().clearSelectedItem();
        div.getTxtNijiHanteibi().clearFromValue();
        div.getTxtNijiHanteibi().clearToValue();
        div.getTxtDispMax().clearValue();
    }

    /**
     * 対象者一覧の設定処理です。
     *
     * @param dataList List<NinteiShienCenterSoshinData>
     */
    public void set対象者一覧(List<NinteiShienCenterSoshinData> dataList) {
        List<dgTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (NinteiShienCenterSoshinData data : dataList) {
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row();
            row.setHokenshano(checkNULL(data.get証記載保険者番号()));
            row.setHokensha(checkNULL(data.get市町村名称()));
            row.setHihokenshaBango(checkNULL(data.get被保険者番号()));
            row.setHihokenshaShimei(data.get被保険者氏名() == null || data.get被保険者氏名().isEmpty()
                    ? RString.EMPTY : data.get被保険者氏名().value());
            row.setHihokenshaShimeiKana(data.get被保険者氏名カナ() == null || data.get被保険者氏名カナ().isEmpty()
                    ? RString.EMPTY : data.get被保険者氏名カナ().value());
            row.setSex(data.get性別() == null || data.get性別().isEmpty()
                    ? RString.EMPTY : Seibetsu.toValue(data.get性別().value()).get名称());
            if (data.get生年月日() != null && !data.get生年月日().isEmpty()) {
                row.getBirthDate().setValue(new RDate(data.get生年月日().toString()));
            }
            if (data.get認定申請年月日() != null && !data.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseibi().setValue(new RDate(data.get認定申請年月日().toString()));
            }
            row.setShinseiKubunShin(get認定申請区分_申請時(data));
            row.setShinseiKubunHo(get認定申請区分_法令(data));
            row.setNijiHanteiKekka(get二次判定結果(data.get厚労省IF識別コード(), data.get二次判定要介護状態区分コード()));
            row.setNinteiYukoKikan(new RString(data.get二次判定認定有効期間()));
            if (data.get二次判定認定有効開始年月日() != null && !data.get二次判定認定有効開始年月日().isEmpty()) {
                row.getYukoKikanstart().setValue(new RDate(data.get二次判定認定有効開始年月日().toString()));
            }
            if (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty()) {
                row.getYukokikanend().setValue(new RDate(data.get二次判定認定有効終了年月日().toString()));
            }
            if (data.getＩＦ送付年月日() != null && !data.getＩＦ送付年月日().isEmpty()) {
                row.getDataShutsuryoku().setValue(new RDate(data.getＩＦ送付年月日().toString()));
            }
            row.setShinseishokanrino(get申請書管理番号(data));
            rowList.add(row);
        }
        div.getDgTaishoshaIchiran().setDataSource(rowList);
        div.getRadTennyuShiboJoho().setSelectedKey(new RString("key0"));
    }

    private RString get認定申請区分_申請時(NinteiShienCenterSoshinData data) {
        if (data.get認定申請区分_申請時_コード() == null || data.get認定申請区分_申請時_コード().isEmpty()) {
            return RString.EMPTY;
        }
        return NinteiShinseiShinseijiKubunCode.toValue(data.get認定申請区分_申請時_コード().value()).get名称();
    }

    private RString get認定申請区分_法令(NinteiShienCenterSoshinData data) {
        if (data.get認定申請区分_法令_コード() == null || data.get認定申請区分_法令_コード().isEmpty()) {
            return RString.EMPTY;
        }
        return NinteiShinseiHoreiCode.toValue(data.get認定申請区分_法令_コード().value()).get名称();
    }

    private RString get申請書管理番号(NinteiShienCenterSoshinData data) {
        if (data.get申請書管理番号() == null || data.get申請書管理番号().isEmpty()) {
            return RString.EMPTY;
        }
        return data.get申請書管理番号().value();
    }

    private RString checkNULL(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private RString get二次判定結果(Code 厚労省IF識別コード, Code 二次判定要介護状態区分コード) {
        RString 二次判定結果 = RString.EMPTY;
        if (厚労省IF識別コード == null || 厚労省IF識別コード.isEmpty()
                || 二次判定要介護状態区分コード == null || 二次判定要介護状態区分コード.isEmpty()) {
            return 二次判定結果;
        }
        if (A_99.equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード.value()).get略称();
        } else if (A_02.equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun02.toValue(二次判定要介護状態区分コード.value()).get略称();
        } else if (A_06.equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun06.toValue(二次判定要介護状態区分コード.value()).get略称();
        } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun09.toValue(二次判定要介護状態区分コード.value()).get略称();
        }
        return 二次判定結果;
    }

}
