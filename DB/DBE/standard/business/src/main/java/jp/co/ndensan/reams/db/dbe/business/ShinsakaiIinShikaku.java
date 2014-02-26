/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 介護認定審査会委員資格を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinShikaku implements ICodeAssignedItem {

    private final RString code;
    private final RString name;
    private final RString shortName;

    /**
     * デフォルトコンストラクタです。
     */
    public ShinsakaiIinShikaku() {
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
        this.shortName = RString.EMPTY;
    }

    /**
     * 引数からコードと名称を受け取るコンストラクタです。
     *
     * @param code コード
     * @param name 名称
     */
    public ShinsakaiIinShikaku(RString code, RString name) {
        this.code = requireNonNull(code, Messages.E00003.replace("コード", getClass().getName()).getMessage());
        this.name = requireNonNull(name, Messages.E00003.replace("名称", getClass().getName()).getMessage());
        this.shortName = RString.EMPTY;
    }

    @Override
    public RString getCode() {
        return code;
    }

    @Override
    public RString getName() {
        return name;
    }

    @Override
    public RString getShortName() {
        return shortName;
    }
}
