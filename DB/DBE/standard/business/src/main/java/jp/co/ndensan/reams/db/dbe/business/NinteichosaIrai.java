/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.MobileDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委依頼情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIrai {

    private final ShinseishoKanriNo 申請書管理番号;
    private final NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
    private final KaigoJigyoshaNo 認定調査委託先コード;
    private final NinteichosainBangoCode 調査員番号コード;
    private final NinteichosaIraiKubun 認定調査依頼区分;
    private final int 認定調査回数;
    private final RDate 認定調査依頼年月日;
    private final RDate 認定調査期限年月日;
    private final RDate 認定調査出力年月日;
    private final RDate 調査票等出力年月日;
    private final MobileDataShutsuryoku モバイルデータ出力;
    private final RDate 認定調査督促年月日;
    private final NinteichosaTokusokuHoho 認定調査督促方法;
    private final int 認定調査督促回数;
    private final RString 認定調査督促メモ;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 調査員番号コード 調査員番号コード
     * @param 認定調査依頼区分 認定調査依頼区分
     * @param 認定調査回数 認定調査回数
     * @param 認定調査依頼年月日 認定調査依頼年月日
     * @param 認定調査期限年月日 認定調査期限年月日
     * @param 認定調査出力年月日 認定調査出力年月日
     * @param 調査票等出力年月日 調査票等出力年月日
     * @param モバイルデータ出力 モバイルデータ出力
     * @param 認定調査督促年月日 認定調査督促年月日
     * @param 認定調査督促方法 認定調査督促方法
     * @param 認定調査督促回数 認定調査督促回数
     * @param 認定調査督促メモ 認定調査督促メモ
     * @throws NullPointerException
     * 申請書管理番号、認定調査委依頼履歴番号、認定調査委託先コード、調査員番号コード、認定調査委依頼区分コードにnullが渡されたとき
     */
    public NinteichosaIrai(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号,
            KaigoJigyoshaNo 認定調査委託先コード, NinteichosainBangoCode 調査員番号コード,
            NinteichosaIraiKubun 認定調査依頼区分, int 認定調査回数, RDate 認定調査依頼年月日,
            RDate 認定調査期限年月日, RDate 認定調査出力年月日, RDate 調査票等出力年月日,
            MobileDataShutsuryoku モバイルデータ出力, RDate 認定調査督促年月日,
            NinteichosaTokusokuHoho 認定調査督促方法, int 認定調査督促回数, RString 認定調査督促メモ) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("申請書管理番号", getClass().getName()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査依頼履歴番号", getClass().getName()));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査委託先コード", getClass().getName()));
        requireNonNull(調査員番号コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("調査員番号コード", getClass().getName()));
        requireNonNull(認定調査依頼区分, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査依頼区分", getClass().getName()));

        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        //TODO n8178 城間篤人 認定調査委託先コードと調査員コードについて、それらを表すクラスが実装された後にメンバを変更 2014年2月末
        this.認定調査委託先コード = 認定調査委託先コード;
        this.調査員番号コード = 調査員番号コード;
        this.認定調査依頼区分 = 認定調査依頼区分;
        this.認定調査回数 = 認定調査回数;
        this.認定調査依頼年月日 = 認定調査依頼年月日;
        this.認定調査期限年月日 = 認定調査期限年月日;
        this.認定調査出力年月日 = 認定調査出力年月日;
        this.調査票等出力年月日 = 調査票等出力年月日;
        this.モバイルデータ出力 = モバイルデータ出力;
        this.認定調査督促年月日 = 認定調査督促年月日;
        this.認定調査督促方法 = 認定調査督促方法;
        this.認定調査督促回数 = 認定調査督促回数;
        this.認定調査督促メモ = 認定調査督促メモ;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public NinteichosaIraiRirekiNo get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public KaigoJigyoshaNo get認定調査委託先コード() {
        return 認定調査委託先コード;
    }

    /**
     * 調査員番号コードを返します。
     *
     * @return 調査員番号コード
     */
    public NinteichosainBangoCode get調査員番号コード() {
        return 調査員番号コード;
    }

    /**
     * 認定調査依頼区分を返します。
     *
     * @return 認定調査依頼区分
     */
    public NinteichosaIraiKubun get認定調査依頼区分() {
        return 認定調査依頼区分;
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return 認定調査回数;
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日
     */
    public RDate get認定調査依頼年月日() {
        return 認定調査依頼年月日;
    }

    /**
     * 認定調査期限年月日を返します。
     *
     * @return 認定調査期限年月日
     */
    public RDate get認定調査期限年月日() {
        return 認定調査期限年月日;
    }

    /**
     * 認定調査出力年月日を返します。
     *
     * @return 認定調査出力年月日
     */
    public RDate get認定調査出力年月日() {
        return 認定調査出力年月日;
    }

    /**
     * 調査票等出力年月日を返します。
     *
     * @return 調査票等出力年月日
     */
    public RDate get調査票等出力年月日() {
        return 調査票等出力年月日;
    }

    /**
     * モバイルデータ出力を返します。
     *
     * @return モバイルデータ出力
     */
    public MobileDataShutsuryoku getモバイルデータ出力() {
        return モバイルデータ出力;
    }

    /**
     * モバイルデータとして出力済みか否かをbool値で返します。
     *
     * @return 出力済みならtrue
     */
    public boolean isモバイルデータ出力済み() {
        return モバイルデータ出力.is出力済();
    }

    /**
     * 認定調査督促年月日を返します。
     *
     * @return 認定調査督促年月日
     */
    public RDate get認定調査督促年月日() {
        return 認定調査督促年月日;
    }

    /**
     * 認定調査督促方法を返します。
     *
     * @return 認定調査督促方法
     */
    public NinteichosaTokusokuHoho get認定調査督促方法() {
        return 認定調査督促方法;
    }

    /**
     * 認定調査督促回数を返します。
     *
     * @return 認定調査督促回数
     */
    public int get認定調査督促回数() {
        return 認定調査督促回数;
    }

    /**
     * 認定調査督促メモを返します。
     *
     * @return 認定調査督促メモ
     */
    public RString get認定調査督促メモ() {
        return 認定調査督促メモ;
    }
}
