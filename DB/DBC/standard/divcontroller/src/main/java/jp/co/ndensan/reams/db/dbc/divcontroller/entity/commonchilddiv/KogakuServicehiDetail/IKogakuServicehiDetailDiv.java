package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;

import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public interface IKogakuServicehiDetailDiv extends ICommonChildDivBaseProperties {

    /**
     * 高額申請一覧共有子DivのInterfaceです。
     *
     * @param 画面モード RString
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @param 識別コード ShikibetsuCode
     */
    public void initialize(RString 画面モード, RString メニューID, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号, int 履歴番号, ShikibetsuCode 識別コード);

    /**
     * clear画面内容
     */
    public void clear画面内容();

    /**
     * 受付日と決定日のチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check受付日と決定日();

    /**
     * 画面初期化データを取得します。
     *
     * @return KougakuSabisuhiShousaiNaiyouResult
     */
    public KougakuSabisuhiShousaiNaiyouResult get画面初期化データ();

    /**
     * 申請日を取得します。
     *
     * @return RDate
     */
    public RDate get申請日();

    /**
     * 申請者区分を取得します。
     *
     * @return RString
     */
    public RString get申請者区分();

    /**
     * 証記載保険者番号を取得します。
     *
     * @return RString
     */
    public RString get証記載保険者番号();

    /**
     * 国保連再送を取得します。
     *
     * @return boolean
     */
    public boolean is国保連再送();

    /**
     * 氏名_漢字を取得します。
     *
     * @return RString
     */
    public RString get氏名_漢字();

    /**
     * 氏名_カナを取得します。
     *
     * @return RString
     */
    public RString get氏名_カナ();

    /**
     * 電話番号を取得します。
     *
     * @return RString
     */
    public RString get電話番号();

    /**
     * 申請理由を取得します。
     *
     * @return RString
     */
    public RString get申請理由();

    /**
     * 支払金額合計を取得します。
     *
     * @return RString
     */
    public Decimal get支払金額合計();

    /**
     * 口座情報エリアを取得します。
     *
     * @return RString
     */
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho();

    /**
     * 受付日を取得します。
     *
     * @return RDate
     */
    public RDate get受付日();

    /**
     * 本人支払額を取得します。
     *
     * @return Decimal
     */
    public Decimal get本人支払額();

    /**
     * 決定日を取得します。
     *
     * @return RDate
     */
    public RDate get決定日();

    /**
     * 支給区分を取得します。
     *
     * @return RString
     */
    public RString get支給区分();

    /**
     * 審査方法区分を取得します。
     *
     * @return RString
     */
    public RString get審査方法区分();

    /**
     * 世帯集約番号を取得します。
     *
     * @return RString
     */
    public RString get世帯集約番号();

    /**
     * 支給金額を取得します。
     *
     * @return Decimal
     */
    public Decimal get支給金額();

    /**
     * 高額自動償還を取得します。
     *
     * @return RString
     */
    public RString get高額自動償還();

    /**
     * 支給しない理由を取得します。
     *
     * @return RString
     */
    public RString get支給しない理由();
}
