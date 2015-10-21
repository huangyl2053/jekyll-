/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiIinKoza;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiIinShikaku;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsakaiIinJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiincode.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護認定審査会委員のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiIinMapper {

    //TODO n8178 城間篤人 他チケットで実装予定の箇所のため、後に改修が入る可能性があり 2014年9月末
    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiIinMapper() {
    }

    /**
     * 審査会委員Entityの情報を、審査会委員クラスにマッピングします。<br/>
     * 引数にnullが渡された場合、nullが返ります。
     *
     * @param 委員Entity 委員entity
     * @return 審査会委員
     */
    public static ShinsakaiIin to審査会委員(DbT5102ShinsakaiIinJohoEntity 委員Entity) {
        if (委員Entity == null) {
            return null;
        }

        return new ShinsakaiIin(new ShinsakaiIinCode(委員Entity.getShinsakaiIinCode()),
                new Range(委員Entity.getShinsakaiIinKaishiYMD(), 委員Entity.getShinsakaiIinShuryoYMD()),
                ShinsakaiIinJokyo.toValue(委員Entity.getShinsakaiIinJokyo()),
                委員Entity.getJigyoshaNo(), 委員Entity.getShinsakaiIinShimei(), 委員Entity.getShinsakaiIinKanaShimei(),
                Gender.toValue(委員Entity.getSeibetsu()),
                create審査員区分(委員Entity),
                ShinsainYusoKubun.toValue(委員Entity.getShinsainYusoKubun()), 委員Entity.getYubinNo(), 委員Entity.getJusho(),
                委員Entity.getTelNo(), create審査会委員口座情報(委員Entity));
    }

    private static ShinsakaiIinShikaku create審査員区分(DbT5102ShinsakaiIinJohoEntity 委員Entity) {
        return new ShinsakaiIinShikaku(委員Entity.getShinsakaiIinShikakuCode(),
                委員Entity.getShinsakaiIinShikakuCodeMeisho(), 委員Entity.getShinsakaiIinShikakuCodeRyakusho());
    }

    private static ShinsakaiIinKoza create審査会委員口座情報(DbT5102ShinsakaiIinJohoEntity 委員Entity) {
        return new ShinsakaiIinKoza(委員Entity.getKinyuKikanCode(), 委員Entity.getKinyuKikanShitenCode(),
                委員Entity.getKozaShubetsu(), 委員Entity.getKozaMeigi(), 委員Entity.getKozaMeigiKana(), 委員Entity.getKozaNo());
    }

    /**
     * 審査会委員EntityListをマッピングして、審査会委員Listを返します。nullが渡されたときは空のリストを返します。
     *
     * @param 委員EntityList 委員EntityList
     * @return 審査会委員List
     */
    public static ShinsakaiIinList to審査会委員List(List<DbT5102ShinsakaiIinJohoEntity> 委員EntityList) {
        if (委員EntityList == null) {
            return new ShinsakaiIinList(Collections.EMPTY_LIST);
        }

        List<ShinsakaiIin> 審査会委員List = new ArrayList<>();
        for (DbT5102ShinsakaiIinJohoEntity 委員Entity : 委員EntityList) {
            審査会委員List.add(to審査会委員(委員Entity));
        }
        return new ShinsakaiIinList(審査会委員List);
    }

    /**
     * 審査会委員の情報を、審査会委員Entityにマッピングします。<br/>
     * 引数にnullが渡されたとき、nullを返します。
     *
     * @param 審査会委員 審査会委員
     * @return 審査会委員Entity
     */
    public static DbT5102ShinsakaiIinJohoEntity to審査会委員Entity(ShinsakaiIin 審査会委員) {
        if (審査会委員 == null) {
            return null;
        }

        DbT5102ShinsakaiIinJohoEntity 委員Entity = new DbT5102ShinsakaiIinJohoEntity();
        委員Entity.setShinsakaiIinCode(審査会委員.get審査会委員コード().value());
        委員Entity.setShinsakaiIinKaishiYMD(審査会委員.get委員着任期間().getFrom());
        委員Entity.setShinsakaiIinShuryoYMD(審査会委員.get委員着任期間().getTo());
        委員Entity.setShinsakaiIinJokyo(審査会委員.get審査会委員状況().is有効());
        委員Entity.setJigyoshaNo(審査会委員.get事業者番号());
        委員Entity.setShinsakaiIinShimei(審査会委員.get氏名());
        委員Entity.setShinsakaiIinKanaShimei(審査会委員.getカナ氏名());
        委員Entity.setSeibetsu(審査会委員.get性別().getCommonName());
        委員Entity.setShinsakaiIinShikakuCode(審査会委員.get審査会委員資格().getShinsakaiIinShikakuCode().asCode());
        委員Entity.setShinsainYusoKubun(審査会委員.get審査委員郵送区分().get郵送区分());
        委員Entity.setYubinNo(審査会委員.get郵便番号());
        委員Entity.setJusho(審査会委員.get住所());
        委員Entity.setTelNo(審査会委員.get電話番号());
        委員Entity.setKinyuKikanCode(審査会委員.get口座情報().get金融機関コード());
        委員Entity.setKinyuKikanShitenCode(審査会委員.get口座情報().get金融機関支店コード());
        委員Entity.setKozaShubetsu(審査会委員.get口座情報().get口座種別());
        委員Entity.setKozaMeigi(審査会委員.get口座情報().get口座名義人());
        委員Entity.setKozaMeigiKana(審査会委員.get口座情報().get口座名義人カナ());
        委員Entity.setKozaNo(審査会委員.get口座情報().get口座番号());
        return 委員Entity;
    }
}
