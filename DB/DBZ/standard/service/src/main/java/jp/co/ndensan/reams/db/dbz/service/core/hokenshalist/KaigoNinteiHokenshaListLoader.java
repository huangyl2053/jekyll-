/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hokenshalist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.IShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定用の保険者リストを取得します。
 */
final class KaigoNinteiHokenshaListLoader {

    private KaigoNinteiHokenshaListLoader() {
    }

    /**
     * インスタンスを生成します。
     *
     * @return KaigoNinteiHokenshaListLoader
     */
    static KaigoNinteiHokenshaListLoader createInstance() {
        return new KaigoNinteiHokenshaListLoader();
    }

    /**
     * 保険者リストを取得して返却します。
     *
     * @return 保険者リスト
     */
    HokenshaList getShichosonCodeNameList() {
        ShichosonSecurityJoho shichosonSecurity = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (shichosonSecurity == null || KaigoDonyuKubun.未導入.code().equals(shichosonSecurity.get介護導入区分().code())) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }

        if (shichosonSecurity.get導入形態コード().is広域()) {
            return HokenshaList.createFor広域(search市町村リストFor広域(shichosonSecurity.get市町村情報()));
        } else {
            return HokenshaList.createFor単一(
                    Arrays.asList(toShichosonCodeNameResult(shichosonSecurity.get市町村情報(), TokeiTaishoKubun.保険者分))
            );
        }
    }

    private static List<HokenshaSummary> search市町村リストFor広域(IShichosonJoho shichosonJoho) {
        List<KoseiShichosonMaster> genShichosonJohoList = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        if (genShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
        }
        RString shichosonShikibetsuID = shichosonJoho.get市町村識別ID().value();
        List<HokenshaSummary> output = new ArrayList<>();
        for (KoseiShichosonMaster genShichosonJoho : genShichosonJohoList) {
            if (shichosonShikibetsuID.equals(new RString("00")) || genShichosonJoho.get市町村識別ID().equals(shichosonShikibetsuID)) {
                output.add(new HokenshaSummary(
                        genShichosonJoho.get市町村コード(),
                        genShichosonJoho.get市町村名称(),
                        genShichosonJoho.get証記載保険者番号(),
                        TokeiTaishoKubun.構成市町村分));
            }
        }
        return output;
    }

    private static HokenshaSummary toShichosonCodeNameResult(IShichosonJoho 市町村情報, TokeiTaishoKubun 保険者区分) {
        return new HokenshaSummary(
                市町村情報.get市町村コード(),
                市町村情報.get市町村名(),
                市町村情報.get証記載保険者番号(),
                保険者区分);
    }
}
