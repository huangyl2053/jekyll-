/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.util;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditor;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;

/**
 *
 * 編集後宛先のクラスです。
 */
public class EditedAtesaki {

    private static final RString 入力郵便番号をセット = new RString("2");
    private final IAtesaki 宛先;
//    private final Association 地方公共団体;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private SofubutsuAtesakiSource 送付物宛先ソース;
    private RString 編集後住所;

    /**
     * コンストラクタです。
     *
     * @param 宛先 宛先
     * @param 帳票制御共通 帳票制御共通
     * @param 送付物宛先ソース 送付物宛先ソース
     * @param 編集後住所 編集後住所
     */
    public EditedAtesaki(IAtesaki 宛先,
            //            Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票制御共通,
            SofubutsuAtesakiSource 送付物宛先ソース,
            RString 編集後住所) {
        this.宛先 = requireNonNull(宛先, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先"));
//        this.地方公共団体 = requireNonNull(地方公共団体, UrSystemErrorMessages.値がnull.getReplacedMessage("地方公共団体"));
        this.帳票制御共通 = requireNonNull(帳票制御共通, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通"));
        this.送付物宛先ソース = 送付物宛先ソース;
        this.編集後住所 = 編集後住所;
    }

    /**
     * 送付物宛先ソースデータを返します。
     *
     * @return 送付物宛先ソースデータ
     */
    public SofubutsuAtesakiSource getSofubutsuAtesakiSource() {
        if (送付物宛先ソース != null) {
            return 送付物宛先ソース;
        }
        SofubutsuAtesakiEditorBuilder builder = new SofubutsuAtesakiEditorBuilder(宛先);
//        TODO 王暁冬 QA752 機能dbz.business→dbb.serviceを呼出し、規約違反 2016/02/24
//        builder.setカスタマーバーコード印字有無(true);
//        builder.set管外住所編集パターン(JushoKangaiEditPattern.space方書);
//        builder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地);
//        builder.set管内住所接頭辞(JushoPrefix.郡_市町村名付加, association);
//        builder.set行政区印字区分(GyoseikuInjiKubun.印字しない);
        builder.set氏名2括弧有無(true);
        builder.set代納区分名印字有無(true);

        SofubutsuAtesakiSource atesakiSource = new SofubutsuAtesakiSourceBuilder(builder.build()).buildSource();

        if (帳票制御共通.isカスタマバーコード使用有無() && atesakiSource.customerBarCode.isEmpty()
                && 入力郵便番号をセット.equals(帳票制御共通.getカスタマバーコード変換エラー編集方法())) {
            atesakiSource.customerBarCode = new CustomerBarCode().convertCustomerBarCode(
                    宛先.get宛先住所().get郵便番号().getYubinNo(), RString.EMPTY).getCustomerBarCode();
            送付物宛先ソース = atesakiSource;
        }
        return 送付物宛先ソース;
    }

    /**
     * 宛先種別を返します。
     *
     * @return 宛先種別
     */
    public AtesakiShubetsu get宛先種別() {
        return 宛先.get宛先種別();
    }

    /**
     * 宛先名称を返します。
     *
     * @return 宛先名称
     */
    public IName get宛先名称() {
        return 宛先.get宛先名称();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get本人識別コード() {
        return 宛先.get識別コード();
    }

    /**
     * 本人名称を返します。
     *
     * @return 本人名称
     */
    public IName get本人名称() {
        return 宛先.get宛先本人名称();
    }

    /**
     * 本人敬称を返します。
     *
     * @return 本人敬称
     */
    public RString get本人敬称() {
        return 宛先.get宛先敬称付与区分().getValue();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return 宛先.get宛先住所().get郵便番号().getEditedYubinNo();
    }

    /**
     * 編集後住所を返します。
     *
     * @return 編集後住所
     */
    public RString get編集後住所() {
        if (編集後住所 != null && !編集後住所.isEmpty()) {
            return 編集後住所;
        }
//        TODO 王暁冬 QA752 機能dbz.business→dbb.serviceを呼出し、規約違反 2016/02/24
        JushoEditorBuilder builder = new JushoEditorBuilder(宛先.get宛先住所());
//        builder.set管外住所編集パターン(JushoKangaiEditPattern.space方書);
//        builder.set管内住所接頭辞(JushoPrefix.郡_市町村名付加, 地方公共団体);
//        builder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地);
//        builder.set行政区(宛先.get宛先行政区());
        JushoEditor editor = builder.build();
        編集後住所 = editor.editJusho().get編集後住所All();
        return 編集後住所;
    }

    /**
     * 町域を返します。
     *
     * @return 町域
     */
    public RString get町域() {
        return 宛先.get宛先住所().get住所();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public RString get番地() {
        return 宛先.get宛先住所().get番地().getBanchi().value();
    }
}
