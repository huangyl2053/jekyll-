/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.basic.helper;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8235 船山洋介
 */
public final class DbT5912ShujiiJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("100001");
    public static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード = new ShujiiIryokikanCode("1000000001");
    public static final ShujiiCode DEFAULT_主治医コード = new ShujiiCode("10000001");
    public static final AtenaMeisho DEFAULT_主治医氏名 = new AtenaMeisho("主治医氏名");
    public static final AtenaKanaMeisho DEFAULT_主治医カナ = new AtenaKanaMeisho("シュジイカナ");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("99999999999");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("99999999990");
    public static final RString DEFAULT_診療科名称 = new RString("診療科名称");
    public static final boolean DEFAULT_指定医フラグ = true;
    public static final boolean DEFAULT_状況フラグ = true;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5912ShujiiJohoEntityGenerator() {
    }

    public static DbT5912ShujiiJohoEntity createDbT5912ShujiiJohoEntity() {
        DbT5912ShujiiJohoEntity entity = new DbT5912ShujiiJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShujiiIryokikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setShujiiName(DEFAULT_主治医氏名);
        entity.setShujiiKana(DEFAULT_主治医カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setShinryokaName(DEFAULT_診療科名称);
        entity.setShiteiiFlag(DEFAULT_指定医フラグ);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
