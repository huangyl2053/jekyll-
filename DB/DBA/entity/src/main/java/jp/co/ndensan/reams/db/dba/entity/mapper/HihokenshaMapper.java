/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.mapper;

import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.ILocalGovernmentCode;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * T1001HihokenshaDaichoEntityをHihokenshaへ変換するクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaMapper {

    private HihokenshaMapper() {
    }

    public static Hihokensha toHihokensha(final T1001HihokenshaDaichoEntity entity) {
        return null;
    }

    private IKaigoShikaku create介護保険資格(final T1001HihokenshaDaichoEntity entity) {
        IKaigoShikaku 介護保険資格 = KaigoShikakuFactory.createInstance(
                null, HokenShubetsu.介護保険,
                entity.getShikakuShutokuTodokedeDate(), entity.getShikakuShutokuDate(), entity.getShikakuShutokuJiyuCode(),
                entity.getShikakuSoshitsuTodokedeDate(), entity.getShikakuSoshitsuDate(), entity.getShikakuSoshitsuJiyuCode(),
                entity.getHihokenshaNo(), entity.getShichosonCd(), entity.getIchigoHihokenshaNenreiTotatsuDate());
        return 介護保険資格;
    }

    private IShikibetsuCode create識別コード(final RString shikibetsuCode) {
        //TODO N3327 三浦凌 識別コードのFactoryクラスを作ったら、それを利用するように修正する。
        return new IShikibetsuCode() {
            @Override
            public RString getValue() {
                return shikibetsuCode;
            }

            @Override
            public int compareTo(IShikibetsuCode o) {
                return getValue().compareTo(o.getValue());
            }
        };
    }

    private ILocalGovernmentCode create地方公共団体コード(final RString shichosonCd) {

        return null;
    }
}
