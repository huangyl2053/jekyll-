/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動保留特定住所マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7023RendoHoryuTokuteiJushoEntityGenerator {

    public static final RString DEFAULT_管理番号 = new RString("123");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ChoikiCode DEFAULT_住所コード = new ChoikiCode(new RString("02"));
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("申請書記載住所");
    public static final BanchiCode DEFAULT_番地コード１ = new BanchiCode(new RString("02"));
    public static final BanchiCode DEFAULT_番地コード２ = new BanchiCode(new RString("02"));
    public static final BanchiCode DEFAULT_番地コード３ = new BanchiCode(new RString("02"));
    public static final AtenaBanchi DEFAULT_番地 = new AtenaBanchi("申請書記載番地");
    public static final RString DEFAULT_施設種類 = new RString("01");
    public static final RString DEFAULT_施設コード = new RString("05652");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7023RendoHoryuTokuteiJushoEntityGenerator() {
    }

    public static DbT7023RendoHoryuTokuteiJushoEntity createDbT7023RendoHoryuTokuteiJushoEntity() {
        DbT7023RendoHoryuTokuteiJushoEntity entity = new DbT7023RendoHoryuTokuteiJushoEntity();
        entity.setKanriNo(DEFAULT_管理番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setJushoCode(DEFAULT_住所コード);
        entity.setJusho(DEFAULT_住所);
        entity.setBanchiCode1(DEFAULT_番地コード１);
        entity.setBanchiCode2(DEFAULT_番地コード２);
        entity.setBanchiCode3(DEFAULT_番地コード３);
        entity.setBanchi(DEFAULT_番地);
        entity.setShisetsuShurui(DEFAULT_施設種類);
        entity.setShisetsuCode(DEFAULT_施設コード);
        return entity;
    }
}
