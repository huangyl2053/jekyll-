/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;

/**
 * 介護認定審査会の委員を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIin {
    //TODO n8178 城間篤人 他チケットで実装予定の箇所のため、後に改修が入る可能性があり 2014年3月末

    private final ShinsakaiIinCode 審査会委員コード;
    private final Range<FlexibleDate> 委員着任期間;
    private final ShinsakaiIinJokyo 審査会委員状況;
    //TODO n8178 城間篤人 事業者コードだけでなく、事業者の情報を持つように修正が必要 2014年10月末
    private final JigyoshaNo 事業者番号;
    private final AtenaMeisho 氏名;
    private final AtenaKanaMeisho カナ氏名;
    private final Gender 性別;
    private final ShinsakaiIinShikaku 審査会委員資格;
    private final ShinsainYusoKubun 審査委員郵送区分;
    private final YubinNo 郵便番号;
    private final AtenaJusho 住所;
    private final TelNo 電話番号;
    private final ShinsakaiIinKoza 口座情報;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 審査会委員コード 審査会委員コード
     * @param 委員着任期間 委員着任期間
     * @param 審査会委員状況 審査会委員状況
     * @param 事業者番号 事業者番号
     * @param 氏名 氏名
     * @param カナ氏名 カナ氏名
     * @param 性別 性別
     * @param 審査会委員資格 審査会委員資格
     * @param 審査委員郵送区分 審査委員郵送区分
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 口座情報 口座情報
     * @throws NullPointerException 引数のいずれかにNullが渡されたとき
     */
    public ShinsakaiIin(ShinsakaiIinCode 審査会委員コード, Range<FlexibleDate> 委員着任期間, ShinsakaiIinJokyo 審査会委員状況,
            JigyoshaNo 事業者番号, AtenaMeisho 氏名, AtenaKanaMeisho カナ氏名, Gender 性別, ShinsakaiIinShikaku 審査会委員資格,
            ShinsainYusoKubun 審査委員郵送区分, YubinNo 郵便番号, AtenaJusho 住所, TelNo 電話番号, ShinsakaiIinKoza 口座情報)
            throws NullPointerException {
        requireNonNull(審査会委員コード, Messages.E00003.replace("審査会委員コード", getClass().getName()).getMessage());
        requireNonNull(委員着任期間, Messages.E00003.replace("委員着任期間", getClass().getName()).getMessage());
        requireNonNull(審査会委員状況, Messages.E00003.replace("審査会委員状況", getClass().getName()).getMessage());
        requireNonNull(事業者番号, Messages.E00003.replace("事業者番号", getClass().getName()).getMessage());
        requireNonNull(氏名, Messages.E00003.replace("氏名", getClass().getName()).getMessage());
        requireNonNull(カナ氏名, Messages.E00003.replace("カナ氏名", getClass().getName()).getMessage());
        requireNonNull(性別, Messages.E00003.replace("性別", getClass().getName()).getMessage());
        requireNonNull(審査会委員資格, Messages.E00003.replace("審査会委員資格", getClass().getName()).getMessage());
        requireNonNull(審査委員郵送区分, Messages.E00003.replace("審査委員郵送区分", getClass().getName()).getMessage());
        requireNonNull(郵便番号, Messages.E00003.replace("郵便番号", getClass().getName()).getMessage());
        requireNonNull(住所, Messages.E00003.replace("住所", getClass().getName()).getMessage());
        requireNonNull(電話番号, Messages.E00003.replace("電話番号", getClass().getName()).getMessage());
        requireNonNull(口座情報, Messages.E00003.replace("口座情報", getClass().getName()).getMessage());

        this.審査会委員コード = 審査会委員コード;
        this.委員着任期間 = 委員着任期間;
        this.審査会委員状況 = 審査会委員状況;
        this.事業者番号 = 事業者番号;
        this.氏名 = 氏名;
        this.カナ氏名 = カナ氏名;
        this.性別 = 性別;
        this.審査会委員資格 = 審査会委員資格;
        this.審査委員郵送区分 = 審査委員郵送区分;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.口座情報 = 口座情報;
    }

    /**
     * 審査会委員コードを返します。
     *
     * @return 審査会委員コード
     */
    public ShinsakaiIinCode get審査会委員コード() {
        return 審査会委員コード;
    }

    /**
     * 着任期間を返します。
     *
     * @return 着任期間
     */
    public Range<FlexibleDate> get委員着任期間() {
        return 委員着任期間;
    }

    /**
     * 審査会委員状況を返します。
     *
     * @return 審査会委員状況
     */
    public ShinsakaiIinJokyo get審査会委員状況() {
        return 審査会委員状況;
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return 事業者番号;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return 氏名;
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public AtenaKanaMeisho getカナ氏名() {
        return カナ氏名;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return 性別;
    }

    /**
     * 審査会委員資格を返します。
     *
     * @return 審査会委員資格
     */
    public ShinsakaiIinShikaku get審査会委員資格() {
        return 審査会委員資格;
    }

    /**
     * 審査委員郵送区分を返します。
     *
     * @return 審査委員郵送区分
     */
    public ShinsainYusoKubun get審査委員郵送区分() {
        return 審査委員郵送区分;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return 郵便番号;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return 住所;
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return 電話番号;
    }

    /**
     * 審査会委員の口座情報を取得します。
     *
     * @return 口座情報
     */
    public ShinsakaiIinKoza get口座情報() {
        return 口座情報;
    }
}
