/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7051KoseiShichosonMasterEntityGenerator {

    public static final RString DEFAULT_市町村識別ID = new RString("12");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("203456");
    public static final RString DEFAULT_国保連広域内市町村番号 = new RString("010");
    public static final RString DEFAULT_市町村名称 = new RString("あいうえおか");
    public static final RString DEFAULT_都道府県名称 = new RString("1234");
    public static final RString DEFAULT_郡名称 = new RString("あいうえ");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("111-1111");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("テスト住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("111-222-3344");
    public static final RString DEFAULT_最優先地区コード = new RString("1");
    public static final RString DEFAULT_帳票用都道府県名称表示有無 = new RString("1");
    public static final RString DEFAULT_帳票用郡名称表示有無 = new RString("1");
    public static final RString DEFAULT_帳票用市町村名称表示有無 = new RString("1");
    public static final RString DEFAULT_帳票用住所編集方法 = new RString("1");
    public static final RString DEFAULT_帳票用方書表示有無 = new RString("1");
    public static final RString DEFAULT_外国人氏名表示方法 = new RString("1");
    public static final RString DEFAULT_老人保健市町村番号 = new RString("あいうえ");
    public static final RString DEFAULT_老人保健受給者番号体系 = new RString("1");
    public static final RString DEFAULT_所得引出方法 = new RString("1");
    public static final RString DEFAULT_納付額データ連携方法 = new RString("1");
    public static final RString DEFAULT_特徴分配集約 = new RString("1");
    public static final FlexibleDate DEFAULT_移行日 = new FlexibleDate("20141216");
    public static final FlexibleDate DEFAULT_加入日 = new FlexibleDate("20141216");
    public static final FlexibleDate DEFAULT_離脱日 = new FlexibleDate("20141216");
    public static final RString DEFAULT_合併旧市町村区分 = new RString("1");
    public static final RString DEFAULT_合併旧市町村表示有無 = new RString("1");
    public static final RString DEFAULT_合併情報地域番号 = new RString("01");
    public static final ShoKisaiHokenshaNo DEFAULT_運用保険者番号 = new ShoKisaiHokenshaNo("203456");
    public static final FlexibleDate DEFAULT_運用開始日 = new FlexibleDate("20141216");
    public static final FlexibleDate DEFAULT_運用終了日 = new FlexibleDate("20141216");
    public static final RString DEFAULT_運用形態区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7051KoseiShichosonMasterEntityGenerator() {
    }

    public static DbT7051KoseiShichosonMasterEntity createDbT7051KoseiShichosonMasterEntity() {
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
        entity.setShichosonShokibetsuID(DEFAULT_市町村識別ID);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setKokuhorenKoikiShichosonNo(DEFAULT_国保連広域内市町村番号);
        entity.setShichosonMeisho(DEFAULT_市町村名称);
        entity.setTodofukenMeisho(DEFAULT_都道府県名称);
        entity.setGunMeisho(DEFAULT_郡名称);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setYusenChikuCode(DEFAULT_最優先地区コード);
        entity.setTyohyoTodoufukenHyojiUmu(DEFAULT_帳票用都道府県名称表示有無);
        entity.setTyohyoGunHyojiUmu(DEFAULT_帳票用郡名称表示有無);
        entity.setTyohyoShichosonHyojiUmu(DEFAULT_帳票用市町村名称表示有無);
        entity.setTyohyoJushoHenshuHouhou(DEFAULT_帳票用住所編集方法);
        entity.setTyohyoKatagakiHyojiUmu(DEFAULT_帳票用方書表示有無);
        entity.setGaikokujinHyojiHouhou(DEFAULT_外国人氏名表示方法);
        entity.setRojinhokenShichosonNo(DEFAULT_老人保健市町村番号);
        entity.setRokenJukyushaNoTaikei(DEFAULT_老人保健受給者番号体系);
        entity.setShotokuHikidashiHoho(DEFAULT_所得引出方法);
        entity.setNofugakuDataRenkeiHoho(DEFAULT_納付額データ連携方法);
        entity.setTokuchoBunpaishuyaku(DEFAULT_特徴分配集約);
        entity.setIkoYMD(DEFAULT_移行日);
        entity.setKanyuYMD(DEFAULT_加入日);
        entity.setRidatsuYMD(DEFAULT_離脱日);
        entity.setGappeiKyuShichosonKubun(DEFAULT_合併旧市町村区分);
        entity.setGappeiKyuShichosonHyojiUmu(DEFAULT_合併旧市町村表示有無);
        entity.setGappeiChiikiNo(DEFAULT_合併情報地域番号);
        entity.setUnyoHokenshaNo(DEFAULT_運用保険者番号);
        entity.setUnyoKaishiYMD(DEFAULT_運用開始日);
        entity.setUnyoShuryoYMD(DEFAULT_運用終了日);
        entity.setUnyoKeitaiKubun(DEFAULT_運用形態区分);
        return entity;
    }
}
