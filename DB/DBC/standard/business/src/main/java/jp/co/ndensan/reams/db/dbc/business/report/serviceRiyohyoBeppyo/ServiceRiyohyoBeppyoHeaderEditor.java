/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.serviceRiyohyoBeppyo;

import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TeikyohyoBeppyoEntityResult;
import jp.co.ndensan.reams.db.dbc.entity.report.source.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC0150011_1_サービス提供票別表Editorのインターフェースクラスです。
 *
 * @reamsid_L DBC-5100-030 tianshuai
 */
public class ServiceRiyohyoBeppyoHeaderEditor implements IServiceRiyohyoBeppyoHeaderEditor {

    private final TeikyohyoBeppyoEntityResult 帳票ヘッダー;
    private final FlexibleDate 作成日時;
    private final FlexibleYearMonth 利用年月;
    private final int 総ページ数;
    private static final int 被保険者名上段長さ = 20;
    private static final RString 居宅_コート = new RString("1");
    private static final RString 提供 = new RString("提供");
    private static final RString 利用 = new RString("利用");
    private static final RString 保険_事業対象分 = new RString("保険/事業対象分");
    private static final RString 保険_事業費 = new RString("保険/事業費");
    private static final RString 総合事業対象分 = new RString("(総合事業対象分)");
    private static final RString 事業費 = new RString("事業費");

    /**
     * インスタンスを生成します。
     *
     * @param 帳票ヘッダー 帳票ヘッダー
     * @param 作成日時 作成日時
     * @param 利用年月 利用年月
     * @param 総ページ数 総ページ数
     */
    protected ServiceRiyohyoBeppyoHeaderEditor(TeikyohyoBeppyoEntityResult 帳票ヘッダー,
            FlexibleDate 作成日時,
            FlexibleYearMonth 利用年月,
            int 総ページ数) {
        this.帳票ヘッダー = 帳票ヘッダー;
        this.作成日時 = 作成日時;
        this.利用年月 = 利用年月;
        this.総ページ数 = 総ページ数;
    }

    @Override
    public ServiceRiyohyoBeppyoSource edit(ServiceRiyohyoBeppyoSource source) {
        return editSource(source);
    }

    private ServiceRiyohyoBeppyoSource editSource(ServiceRiyohyoBeppyoSource source) {
        setタイトル部(source);
        setヘッダー部(source);
        return source;
    }

    private void setタイトル部(ServiceRiyohyoBeppyoSource source) {
        source.nengo = this.利用年月.wareki().toDateString();
        source.hihoNo = this.帳票ヘッダー.get被保険者番号().getColumnValue();
        RString name = RString.EMPTY;
        if (this.帳票ヘッダー.get宛名() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(this.帳票ヘッダー.get宛名());
            name = 宛名.get名称().getName().getColumnValue();
        }
        if (RString.isNullOrEmpty(name) || name.length() <= 被保険者名上段長さ) {
            source.hihoMei1 = name;
            source.hihoMei2 = RString.EMPTY;
        }
        if (name.length() > 被保険者名上段長さ) {
            source.hihoMei1 = name.substring(0, 被保険者名上段長さ);
            source.hihoMei2 = name.substring(被保険者名上段長さ);
        }
        if (居宅_コート.equals(this.帳票ヘッダー.get総合事業区分())) {
            source.title = 提供;
        } else {
            source.title = 利用;
        }
    }

    private void setヘッダー部(ServiceRiyohyoBeppyoSource source) {
        if (居宅_コート.equals(this.帳票ヘッダー.get総合事業区分())) {
            source.headHiyouSougaku = 保険_事業対象分;
            source.headSeikyugaku = 保険_事業費;
            source.headRiyoushaFutan = 保険_事業対象分;
        } else {
            source.headHiyouSougaku = 総合事業対象分;
            source.headSeikyugaku = 事業費;
            source.headRiyoushaFutan = 総合事業対象分;
        }
        source.shoriYmdHms = this.作成日時.wareki().toDateString();
        source.pagecnt = new RString(this.総ページ数);
    }
}
