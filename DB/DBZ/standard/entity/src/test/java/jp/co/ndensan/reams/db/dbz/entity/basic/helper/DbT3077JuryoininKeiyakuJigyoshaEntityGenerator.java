/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3077JuryoininKeiyakuJigyoshaEntityGenerator {

    public static final RString DEFAULT_事業者契約番号 = new RString("1");
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_終了年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_届出年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_届出者住所 = new RString("1");
    public static final RString DEFAULT_届出者事業者名称 = new RString("1");
    public static final RString DEFAULT_届出者代表者氏名 = new RString("1");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final TelNo DEFAULT_事業者FAX番号 = new TelNo("012-345-6789");
    public static final FlexibleDate DEFAULT_契約登録年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_送付先部署 = new RString("1");
    public static final RString DEFAULT_営業形態 = new RString("1");
    public static final boolean DEFAULT_住宅改修契約有無 = false;
    public static final boolean DEFAULT_特定福祉用具販売契約有無 = false;
    public static final boolean DEFAULT_償還払給付契約有無 = false;
    public static final boolean DEFAULT_高額給付契約有無 = false;
    public static final JigyoshaNo DEFAULT_契約事業者番号 = new JigyoshaNo(new RString("2"));
    public static final boolean DEFAULT_取扱確約書有無 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3077JuryoininKeiyakuJigyoshaEntityGenerator() {
    }

    public static DbT3077JuryoininKeiyakuJigyoshaEntity createDbT3077JuryoininKeiyakuJigyoshaEntity() {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(DEFAULT_事業者契約番号);
        entity.setKaishiYMD(DEFAULT_開始年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShuryoYMD(DEFAULT_終了年月日);
        entity.setTodokedeYMD(DEFAULT_届出年月日);
        entity.setTodokedeAddress(DEFAULT_届出者住所);
        entity.setTodokedeJigyoshaName(DEFAULT_届出者事業者名称);
        entity.setTodokedeDaihyoshaName(DEFAULT_届出者代表者氏名);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setJigyoshaFaxNo(DEFAULT_事業者FAX番号);
        entity.setKeiyakuTorokuYMD(DEFAULT_契約登録年月日);
        entity.setSofusakiBusho(DEFAULT_送付先部署);
        entity.setEigyoKeitai(DEFAULT_営業形態);
        entity.setJutakuKaishuKeiyakuUmu(DEFAULT_住宅改修契約有無);
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(DEFAULT_特定福祉用具販売契約有無);
        entity.setShokanbaraiKyufuKeiyakuUmu(DEFAULT_償還払給付契約有無);
        entity.setKogakuKyufuKeiyakuUmu(DEFAULT_高額給付契約有無);
        entity.setKeiyakuJigyoshaNo(DEFAULT_契約事業者番号);
        entity.setToriatsukaiKakuyakushoUmu(DEFAULT_取扱確約書有無);
        return entity;
    }
}
