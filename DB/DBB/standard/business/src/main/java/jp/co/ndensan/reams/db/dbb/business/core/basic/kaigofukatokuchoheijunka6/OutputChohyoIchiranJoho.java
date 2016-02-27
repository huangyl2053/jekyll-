/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka6;

import jp.co.ndensan.reams.db.dbb.entity.dbbbt35003.OutputChohyoIchiranEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 介護徴収方法を管理するクラスです。
 */
public class OutputChohyoIchiranJoho {

    private final OutputChohyoIchiranEntity entity;

    /**
     * コンストラクタです。<br/>
     *
     */
    public OutputChohyoIchiranJoho() {
        this.entity = new OutputChohyoIchiranEntity();
    }

    /**
     * 帳票名を取得します。
     *
     * @return 帳票名
     */
    public RString getChohyoName() {
        return entity.getChohyoName();
    }

    /**
     * 帳票名を設定します。
     *
     * @param chohyoName 帳票名
     */
    public void setChohyoName(RString chohyoName) {
        entity.setChohyoName(chohyoName);

    }

    /**
     * 出力順を取得します。
     *
     * @return 出力順
     */
    public RString getShutsuryokujun() {
        return entity.getShutsuryokujun();
    }

    /**
     * 出力順を設定します。
     *
     * @param shutsuryokujun 出力順
     */
    public void setShutsuryokujun(RString shutsuryokujun) {
        entity.setShutsuryokujun(shutsuryokujun);

    }

    /**
     * 表示順を取得します。
     *
     * @return 表示順
     */
    public TextBoxNum getHdnHyojijun() {
        return entity.getHdnHyojijun();
    }

    /**
     * 表示順を設定します。
     *
     * @param hdnHyojijun 表示順
     */
    public void setHdnHyojijun(TextBoxNum hdnHyojijun) {
        entity.setHdnHyojijun(hdnHyojijun);
    }

}
