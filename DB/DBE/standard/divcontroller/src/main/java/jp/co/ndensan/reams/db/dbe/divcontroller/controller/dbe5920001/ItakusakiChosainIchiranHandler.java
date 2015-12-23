/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe5920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.itakusakichosainichiran.ItakusakiChosainIchiranBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.JyoukyouType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NarabiJunType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NextPageType;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5920001.ItakusakiChosainIchiranDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託先・認定調査員一覧表のHandlerクラスです。
 */
public class ItakusakiChosainIchiranHandler {

    private static final RString 状況_有効のみ = new RString("key0");
    private static final RString 状況_無効のみ = new RString("key1");
    private static final RString 委託先コード_調査員コード = new RString("key0");
    private static final RString 委託先コード_調査員氏名 = new RString("key1");
    private static final RString 委託先コード_調査員カナ氏名 = new RString("key2");
    private static final RString 委託先名称_調査員コード = new RString("key3");
    private static final RString 委託先名称_調査員氏名 = new RString("key4");
    private final ItakusakiChosainIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報DIV
     */
    public ItakusakiChosainIchiranHandler(ItakusakiChosainIchiranDiv div) {
        this.div = div;
    }

    /**
     * 一覧表を発行するボタン押下処理です。
     *
     * @return ItakusakiChosainIchiranBatchParamter
     */
    public ItakusakiChosainIchiranBatchParamter onclick_一覧表を発行する() {
        ItakusakiChosainIchiranBatchParamter param = new ItakusakiChosainIchiranBatchParamter();
        if (div.getTxtIryoKikanCodeFrom().getValue().compareTo(
                div.getTxtIryoKikanCodeTo().getValue()) > 0) {
            throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("委託先コード"));
        }
        if (div.getTxtShujiiCodeFrom().getValue().compareTo(
                div.getTxtShujiiCodeTo().getValue()) > 0) {
            throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("調査員コード"));
        }
        param.setShichosonCode(div.getDdlShichosonCode().getSelectedKey());
        param.setShichosonMeisho(div.getDdlShichosonCode().getSelectedValue());
        param.setItakusakiCodeFrom(div.getTxtIryoKikanCodeFrom().getValue());
        param.setItakusakiCodeTo(div.getTxtIryoKikanCodeTo().getValue());
        param.setChosainNoFrom(div.getTxtShujiiCodeFrom().getValue());
        param.setChosainNoTo(div.getTxtShujiiCodeTo().getValue());
        setパラメータ状況(param);
        setパラメータ並び順(param);
        setパラメータ改頁(param);
        return param;
    }

    private void setパラメータ状況(ItakusakiChosainIchiranBatchParamter param) {
        if (状況_有効のみ.equals(div.getRadJyokyo().getSelectedKey())) {
            param.setJyoukyou(JyoukyouType.有効のみ.code());
        } else if (状況_無効のみ.equals(div.getRadJyokyo().getSelectedKey())) {
            param.setJyoukyou(JyoukyouType.無効のみ.code());
        } else {
            param.setJyoukyou(JyoukyouType.全て.code());
        }
    }

    private void setパラメータ並び順(ItakusakiChosainIchiranBatchParamter param) {
        if (委託先コード_調査員コード.equals(div.getDdlOutputSort().getSelectedKey())) {
            param.setNarabiJun(NarabiJunType.委託先コード_調査員コード.code());
        } else if (委託先コード_調査員氏名.equals(div.getDdlOutputSort().getSelectedKey())) {
            param.setNarabiJun(NarabiJunType.委託先コード_調査員氏名.code());
        } else if (委託先コード_調査員カナ氏名.equals(div.getDdlOutputSort().getSelectedKey())) {
            param.setNarabiJun(NarabiJunType.委託先コード_調査員カナ氏名.code());
        } else if (委託先名称_調査員コード.equals(div.getDdlOutputSort().getSelectedKey())) {
            param.setNarabiJun(NarabiJunType.委託先名称_調査員コード.code());
        } else if (委託先名称_調査員氏名.equals(div.getDdlOutputSort().getSelectedKey())) {
            param.setNarabiJun(NarabiJunType.委託先名称_調査員氏名.code());
        } else {
            param.setNarabiJun(NarabiJunType.委託先名称_調査員カナ氏名.code());
        }
    }

    private void setパラメータ改頁(ItakusakiChosainIchiranBatchParamter param) {
        if (状況_有効のみ.equals(div.getDdlNextpage().getSelectedKey())) {
            param.setNextPage(NextPageType.委託先コード.code());
        } else {
            param.setNextPage(NextPageType.なし.code());
        }
    }
}
