/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE592001.DBE592001_ItakusakiChosainParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.JyoukyouType;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.NarabiJunType;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.NextPageType;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5920001.ItakusakiChosainIchiranDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託先・認定調査員一覧表のHandlerクラスです。
 *
 * @reamsid_L DBE-0290-010 dongyabin
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
     * @return DBE592001_ItakusakiChosainParameter
     */
    public DBE592001_ItakusakiChosainParameter onclick_Publis() {
        DBE592001_ItakusakiChosainParameter param = new DBE592001_ItakusakiChosainParameter();
        param.setShichosonCode(div.getHokensha().getSelectedItem().get市町村コード().getColumnValue());
        param.setShichosonMeisho(div.getHokensha().getSelectedItem().get市町村名称());
        if (RString.isNullOrEmpty(div.getTxtIryoKikanCodeFrom().getValue())) {
            param.setItakusakiCodeFrom(RString.EMPTY);
        } else {
            param.setItakusakiCodeFrom(div.getTxtIryoKikanCodeFrom().getValue());
        }
        if (RString.isNullOrEmpty(div.getTxtIryoKikanCodeTo().getValue())) {
            param.setItakusakiCodeTo(RString.EMPTY);
        } else {
            param.setItakusakiCodeTo(div.getTxtIryoKikanCodeTo().getValue());
        }
        if (RString.isNullOrEmpty(div.getTxtShujiiCodeFrom().getValue())) {
            param.setChosainNoFrom(RString.EMPTY);
        } else {
            param.setChosainNoFrom(div.getTxtShujiiCodeFrom().getValue());
        }
        if (RString.isNullOrEmpty(div.getTxtShujiiCodeTo().getValue())) {
            param.setChosainNoTo(RString.EMPTY);
        } else {
            param.setChosainNoTo(div.getTxtShujiiCodeTo().getValue());
        }
        setパラメータ状況(param);
        setパラメータ並び順(param);
        setパラメータ改頁(param);
        return param;
    }

    private void setパラメータ状況(DBE592001_ItakusakiChosainParameter param) {
        if (状況_有効のみ.equals(div.getRadJyokyo().getSelectedKey())) {
            param.setJyoukyou(JyoukyouType.有効のみ.code());
        } else if (状況_無効のみ.equals(div.getRadJyokyo().getSelectedKey())) {
            param.setJyoukyou(JyoukyouType.無効のみ.code());
        } else {
            param.setJyoukyou(JyoukyouType.全て.code());
        }
    }

    private void setパラメータ並び順(DBE592001_ItakusakiChosainParameter param) {
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

    private void setパラメータ改頁(DBE592001_ItakusakiChosainParameter param) {
        if (状況_有効のみ.equals(div.getDdlNextpage().getSelectedKey())) {
            param.setNextPage(NextPageType.委託先コード.code());
        } else {
            param.setNextPage(NextPageType.なし.code());
        }
    }
}
