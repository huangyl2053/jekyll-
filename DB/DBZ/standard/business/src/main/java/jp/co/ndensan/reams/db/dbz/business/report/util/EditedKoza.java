/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.util;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 編集後口座のクラスです。
 */
public class EditedKoza {

    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private final IKoza 口座;
    private final ChohyoSeigyoKyotsu 帳票制御共通;

    /**
     * コンストラクタです。
     *
     * @param 口座 口座
     * @param 帳票制御共通 帳票制御共通
     */
    public EditedKoza(IKoza 口座, ChohyoSeigyoKyotsu 帳票制御共通) {
        this.口座 = 口座;
        this.帳票制御共通 = 帳票制御共通;
    }

    /**
     * 金融機関コードと支店コードを半角ハイフンで連結した文字列を返します。
     *
     * @return 金融機関コード
     */
    public RString get金融機関コードCombinedWith支店コード() {
        return 口座 == null ? RString.EMPTY : 口座.getCombined金融機関コードand支店コード('-');
    }

    /**
     * 金融機関名と支店名を全角スペースで連結した文字列を返します。
     *
     * @return 金融機関名
     */
    public RString get金融機関名CombinedWith支店名() {
        return 口座 == null ? RString.EMPTY : 口座.getCombined金融機関名and支店名('　');
    }

    /**
     * 口座種別の略称を返却します。
     *
     * @return 口座種別略称
     */
    public RString get口座種別略称() {
        return 口座 == null ? RString.EMPTY : 口座.get預金種別().get預金種別略称();
    }

    /**
     * 金融機関の種類によって口座番号か通帳記号番号を返却します。
     *
     * @return 口座番号
     */
    public RString get口座番号Or通帳記号番号() {
        if (口座 == null) {
            return RString.EMPTY;
        } else if (口座.isゆうちょ銀行()) {
            return 口座.getEdited通帳記号番号();
        } else {
            return 口座.get口座番号();
        }
    }

    /**
     * 口座名義人の名称について、帳票制御共通に管理される優先順で、漢字またはカナを返します。
     *
     * @return 口座名義人
     */
    public RString get口座名義人優先() {
        if (口座 != null) {
            if (表示する.equals(帳票制御共通.get口座名義人カナ優先区分())) {
                return get口座名義人カナ優先();
            } else if (表示しない.equals(帳票制御共通.get口座名義人カナ優先区分())) {
                return get口座名義人漢字優先();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 口座名義人の名称について、カナ＞漢字の優先順で返却します。
     *
     * @return 口座名義人カナ優先
     */
    public RString get口座名義人カナ優先() {
        if (口座 != null) {
            if (口座.get口座名義人() != null && !口座.get口座名義人().isEmpty()) {
                return 口座.get口座名義人().value();
            } else {
                return 口座.get口座名義人漢字().value();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 口座名義人の名称について、漢字＞カナの優先順で返却します。
     *
     * @return 口座名義人漢字優先
     */
    public RString get口座名義人漢字優先() {
        if (口座 != null) {
            if (口座.get口座名義人漢字() != null && !口座.get口座名義人漢字().isEmpty()) {
                return 口座.get口座名義人漢字().value();
            } else {
                return 口座.get口座名義人().value();
            }
        }
        return RString.EMPTY;
    }

    /**
     * isゆうちょ銀行を返します。
     *
     * @return isゆうちょ銀行
     */
    // TODO 王暁冬 QA751 仕様書記述不一致　メソッド返却する型boolean→RString 2016/02/24
    public boolean isゆうちょ銀行() {
        return 口座 == null ? false : 口座.isゆうちょ銀行();
    }

    /**
     * ゆうちょ銀行(振替用口座)の場合は「通帳番号」、それ以外の場合は「口座番号」を返します。
     *
     * @return 番号名称
     */
    public RString get番号名称() {
        if (口座 == null) {
            return RString.EMPTY;
        }
        if (口座.isゆうちょ銀行()) {
            return new RString("通帳番号");
        } else {
            return new RString("口座番号");
        }
    }

    /**
     * 口座の情報が存在する場合はtrue、存在しない場合はfalseを返却します。
     *
     * @return 存在確認
     */
    // TODO 王暁冬 QA751 仕様書記述不一致　メソッド返却する型boolean→RString  2016/02/24
    public boolean isPresent() {
        return 口座 != null;
    }
}
