/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 合議体名称を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiMeisho implements IValueObject<RString>, IDbColumnMappable {

    private final RString 合議体名称;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体名称 合議体名称
     * @throws NullPointerException 引数にNullが渡されたとき
     */
    public GogitaiMeisho(RString 合議体名称) throws NullPointerException {
        this.合議体名称 = requireNonNull(合議体名称,
                Messages.E00003.replace("合議体名称", getClass().getName()).getMessage());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.合議体名称);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((GogitaiMeisho) 比較対象).value().equals(合議体名称);
    }

    @Override
    public RString value() {
        return 合議体名称;
    }

    @Override
    public RString getColumnValue() {
        return 合議体名称;
    }
}
