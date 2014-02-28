/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChikuCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 審査会開催地区を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaisaiChiku {

    private final ShinsakaiKaisaiChikuCode 地区コード;
    private final RString 地区名称;

    /**
     * 引数からコードと名称を受け取るコンストラクタです。
     *
     * @param 地区コード 地区コード
     * @param 地区名称 地区名称
     * @throws NullPointerException 引数のいずれかにNullが渡されたとき
     */
    public ShinsakaiKaisaiChiku(ShinsakaiKaisaiChikuCode 地区コード, RString 地区名称) throws NullPointerException {
        this.地区コード = requireNonNull(地区コード, Messages.E00003.replace("地区コード", getClass().getName()).getMessage());
        this.地区名称 = requireNonNull(地区名称, Messages.E00003.replace("地区名称", getClass().getName()).getMessage());
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public ShinsakaiKaisaiChikuCode get地区コード() {
        return 地区コード;
    }

    /**
     * 地区名称を返します。
     *
     * @return 地区名称
     */
    public RString get地区名称() {
        return 地区名称;
    }
}
