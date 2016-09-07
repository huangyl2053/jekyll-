/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.Gyoseiku;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号登録のビジネスクラスです
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Minashi2shisaiJoho implements Serializable {

    private static final long serialVersionUID = 112571015917464062L;
    private HokenshaSummary 保険者;
    private RString 被保険者番号;
    private RString 氏名;
    private RString カナ氏名;
    private YubinNo 郵便番号;
    private ZenkokuJushoCode 住所コード;
    private RString 住所名称;
    private TelNo 電話番号;
    private RString 識別コード;
    private RString 個人番号;
    private RString 世帯コード;
    private RString 行政区コード;
    private RString 行政区名称;
    private SubGyomuCode サブ業務コード;
    private RDate 生年月日;
    private RString 性別コード;
    private RString 支所コード;
    private ShinseishoKanriNo 前回申請書管理番号;

    /**
     * 保険者を設定します。
     *
     * @param 保険者 保険者
     */
    public void set保険者(HokenshaSummary 保険者) {
        this.保険者 = 保険者;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 氏名を設定します。
     *
     * @param 氏名 氏名
     */
    public void set氏名(RString 氏名) {
        this.氏名 = 氏名;
    }

    /**
     * カナ氏名を設定します。
     *
     * @param カナ氏名 カナ氏名
     */
    public void setカナ氏名(RString カナ氏名) {
        this.カナ氏名 = カナ氏名;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(YubinNo 郵便番号) {
        this.郵便番号 = 郵便番号;
    }

    /**
     * 住所名称を設定します。
     *
     * @param 住所名称 住所名称
     */
    public void set住所名称(RString 住所名称) {
        this.住所名称 = 住所名称;
    }

    /**
     * 住所コードを設定します。
     *
     * @param 住所コード 住所コード
     */
    public void set住所コード(ZenkokuJushoCode 住所コード) {
        this.住所コード = 住所コード;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     */
    public void set電話番号(TelNo 電話番号) {
        this.電話番号 = 電話番号;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 個人番号を設定します。
     *
     * @param 個人番号 個人番号
     */
    public void set個人番号(RString 個人番号) {
        this.個人番号 = 個人番号;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     */
    public void set世帯コード(RString 世帯コード) {
        this.世帯コード = 世帯コード;
    }

    /**
     * 行政区コードを設定します。
     *
     * @param 行政区コード 行政区コード
     */
    public void set行政区コード(RString 行政区コード) {
        this.行政区コード = 行政区コード;
    }

    /**
     * 行政区名称を設定します。
     *
     * @param 行政区名称 行政区名称
     */
    public void set行政区名称(RString 行政区名称) {
        this.行政区名称 = 行政区名称;
    }

    /**
     * サブ業務コードを設定します。
     *
     * @param サブ業務コード サブ業務コード
     */
    public void setサブ業務コード(SubGyomuCode サブ業務コード) {
        this.サブ業務コード = サブ業務コード;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     */
    public void set生年月日(RDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     */
    public void set性別コード(RString 性別コード) {
        this.性別コード = 性別コード;
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     */
    public void set支所コード(RString 支所コード) {
        this.支所コード = 支所コード;
    }

    /**
     * 前回申請書管理番号を設定します。
     *
     * @param 前回申請書管理番号 前回申請書管理番号
     */
    public void set前回申請書管理番号(ShinseishoKanriNo 前回申請書管理番号) {
        this.前回申請書管理番号 = 前回申請書管理番号;
    }

    /**
     * 前回申請書管理番号を取得します。
     *
     * @return 前回申請書管理番号
     */
    public ShinseishoKanriNo get前回申請書管理番号() {
        return 前回申請書管理番号;
    }

    /**
     * 支所コードを取得します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return 支所コード;
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public HokenshaSummary get保険者() {
        return 保険者;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return new HihokenshaNo(被保険者番号);
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return new AtenaMeisho(氏名);
    }

    /**
     * カナ氏名を取得します。
     *
     * @return カナ氏名
     */
    public AtenaKanaMeisho getカナ氏名() {
        return new AtenaKanaMeisho(カナ氏名);
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public RDate get生年月日() {
        return 生年月日;
    }

    /**
     * 性別コードを取得します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return 性別コード;
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return 郵便番号;
    }

    /**
     * 住所名称を取得します。
     *
     * @return 住所名称
     */
    public RString get住所名称() {
        return 住所名称;
    }

    /**
     * 住所コードを取得します。
     *
     * @return 住所コード
     */
    public ZenkokuJushoCode get住所コード() {
        return 住所コード;
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return 電話番号;
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return new ShikibetsuCode(識別コード);
    }

    /**
     * 個人番号を取得します。
     *
     * @return 個人番号
     */
    public KojinNo get個人番号() {
        return new KojinNo(個人番号);
    }

    /**
     * 世帯コードを取得します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return new SetaiCode(世帯コード);
    }

    /**
     * 行政区を取得します。
     *
     * @return 行政区
     */
    public Gyoseiku get行政区() {
        return new Gyoseiku(new GyoseikuCode(行政区コード), 行政区名称);
    }

    /**
     * サブ業務コードを取得します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return サブ業務コード;
    }
}
