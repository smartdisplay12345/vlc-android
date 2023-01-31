package org.videolan.vlc.gui.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00e2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u0000 \u00ec\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002\u00ec\u0003B\u0005\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u00ab\u0002\u001a\u00030\u00ac\u00022\n\u0010\u00ad\u0002\u001a\u0005\u0018\u00010\u00ae\u0002H\u0016J1\u0010\u00af\u0002\u001a\u00030\u00ac\u00022\n\u0010\u00ad\u0002\u001a\u0005\u0018\u00010\u00b0\u00022\u0007\u0010\u00b1\u0002\u001a\u00020\f2\u0007\u0010\u00b2\u0002\u001a\u00020\f2\u0007\u0010\u00b3\u0002\u001a\u00020\fH\u0016J\n\u0010\u00b4\u0002\u001a\u00030\u00ac\u0002H\u0016J\u0019\u0010\u00b5\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00b6\u0002\u001a\u00020WH\u0000\u00a2\u0006\u0003\b\u00b7\u0002J\u0013\u0010\u00b8\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00b6\u0002\u001a\u00020WH\u0002J\n\u0010\u00b9\u0002\u001a\u00030\u00ac\u0002H\u0002J\u0014\u0010\u00ba\u0002\u001a\u00030\u00bb\u00022\b\u0010\u00bc\u0002\u001a\u00030\u00bd\u0002H\u0016J\n\u0010\u00be\u0002\u001a\u00030\u00ac\u0002H\u0016J\u0016\u0010\u00bf\u0002\u001a\u00030\u00ac\u00022\n\u0010\u00c0\u0002\u001a\u0005\u0018\u00010\u00c1\u0002H\u0016J\u0013\u0010\u00c2\u0002\u001a\u00020\u00192\b\u0010\u00c3\u0002\u001a\u00030\u00c4\u0002H\u0016J\u0007\u0010\u00c5\u0002\u001a\u00020\u0019J\b\u0010\u00c6\u0002\u001a\u00030\u00ac\u0002J\b\u0010\u00c7\u0002\u001a\u00030\u00ac\u0002J\n\u0010\u00c8\u0002\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00c9\u0002\u001a\u00030\u00ac\u0002H\u0002J\u0013\u0010\u00ca\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00cb\u0002\u001a\u00020\fH\u0016J\n\u0010\u00cc\u0002\u001a\u00030\u00ac\u0002H\u0002J\u0014\u0010\u00cd\u0002\u001a\u00030\u00ac\u00022\b\u0010\u00c0\u0002\u001a\u00030\u00c1\u0002H\u0016J\t\u0010\u00ce\u0002\u001a\u00020\fH\u0002J\n\u0010\u00cf\u0002\u001a\u00030\u00bb\u0002H\u0016J\u000f\u0010\u00d0\u0002\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\t\u0010\u00d1\u0002\u001a\u00020)H\u0016J\t\u0010\u00d2\u0002\u001a\u00020\fH\u0002J\u0013\u0010\u00d3\u0002\u001a\u00020\f2\b\u0010\u00d4\u0002\u001a\u00030\u00ae\u0001H\u0007J\u0013\u0010\u00d5\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00d6\u0002\u001a\u00020\fH\u0002J\n\u0010\u00d7\u0002\u001a\u00030\u00ac\u0002H\u0002J\b\u0010\u00d8\u0002\u001a\u00030\u00ac\u0002J\t\u0010\u00d9\u0002\u001a\u00020\u0019H\u0002J\n\u0010\u00da\u0002\u001a\u00030\u00ac\u0002H\u0016J\u0015\u0010\u00db\u0002\u001a\u0005\u0018\u00010\u00ac\u0002H\u0000\u00a2\u0006\u0006\b\u00dc\u0002\u0010\u00dd\u0002J\n\u0010\u00de\u0002\u001a\u00030\u00ac\u0002H\u0002J\t\u0010\u00df\u0002\u001a\u00020\u0019H\u0016J\t\u0010\u00e0\u0002\u001a\u00020\u0019H\u0016J \u0010\u00e1\u0002\u001a\u00030\u00ac\u00022\t\b\u0002\u0010\u00e2\u0002\u001a\u00020\u00192\t\b\u0002\u0010\u00e3\u0002\u001a\u00020\u0019H\u0015J\u0013\u0010\u00e4\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00e4\u0002\u001a\u00020\u0019H\u0002J\u0018\u0010\u00e5\u0002\u001a\u00020\u00192\u0007\u0010\u00e6\u0002\u001a\u00020\fH\u0000\u00a2\u0006\u0003\b\u00e7\u0002J\n\u0010\u00e8\u0002\u001a\u00030\u00ac\u0002H\u0016J\n\u0010\u00e9\u0002\u001a\u00030\u00ac\u0002H\u0002J(\u0010\u00ea\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00eb\u0002\u001a\u00020\f2\u0007\u0010\u00cb\u0002\u001a\u00020\f2\n\u0010\u00ec\u0002\u001a\u0005\u0018\u00010\u00ed\u0002H\u0014J\n\u0010\u00ee\u0002\u001a\u00030\u00ac\u0002H\u0016J\u0016\u0010\u00ef\u0002\u001a\u00030\u00ac\u00022\n\u0010\u00f0\u0002\u001a\u0005\u0018\u00010\u00d2\u0001H\u0016J\u0011\u0010\u00f1\u0002\u001a\u00030\u00ac\u00022\u0007\u0010\u00f2\u0002\u001a\u000203J\u0014\u0010\u00f3\u0002\u001a\u00030\u00ac\u00022\b\u0010\u00f4\u0002\u001a\u00030\u00d2\u0001H\u0016J\u0012\u0010\u00f5\u0002\u001a\u00030\u00ac\u00022\b\u0010\u00f4\u0002\u001a\u00030\u00d2\u0001J\u0014\u0010\u00f6\u0002\u001a\u00030\u00ac\u00022\n\u0010\u00f4\u0002\u001a\u0005\u0018\u00010\u00d2\u0001J\u0014\u0010\u00f7\u0002\u001a\u00030\u00ac\u00022\b\u0010\u00f8\u0002\u001a\u00030\u00bd\u0002H\u0016J\u0016\u0010\u00f9\u0002\u001a\u00030\u00ac\u00022\n\u0010\u00fa\u0002\u001a\u0005\u0018\u00010\u00fb\u0002H\u0015J\n\u0010\u00fc\u0002\u001a\u00030\u00ac\u0002H\u0014J\u001c\u0010\u00fd\u0002\u001a\u00020\u00192\u0007\u0010\u00e6\u0002\u001a\u00020\f2\b\u0010\u00c3\u0002\u001a\u00030\u00fe\u0002H\u0016J\u0013\u0010\u00ff\u0002\u001a\u00020\u00192\b\u0010\u00f4\u0002\u001a\u00030\u00d2\u0001H\u0016J\u0014\u0010\u0080\u0003\u001a\u00030\u00ac\u00022\b\u0010\u00c3\u0002\u001a\u00030\u0081\u0003H\u0016J\u0014\u0010\u0082\u0003\u001a\u00030\u00ac\u00022\b\u0010\u00c3\u0002\u001a\u00030\u0083\u0003H\u0016J\u0014\u0010\u0084\u0003\u001a\u00030\u00ac\u00022\b\u0010\u0085\u0003\u001a\u00030\u00ed\u0002H\u0014J\n\u0010\u0086\u0003\u001a\u00030\u00ac\u0002H\u0015J\u0013\u0010\u0087\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00df\u0002\u001a\u00020\u0019H\u0016J\n\u0010\u0088\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u0089\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u008a\u0003\u001a\u00030\u00ac\u0002H\u0002J)\u0010\u008b\u0003\u001a\u00030\u00ac\u00022\b\u0010\u008c\u0003\u001a\u00030\u00d2\u00012\u0007\u0010\u008d\u0003\u001a\u00020\f2\n\u0010\u008e\u0003\u001a\u0005\u0018\u00010\u00c8\u0001H\u0016J\u0014\u0010\u008f\u0003\u001a\u00030\u00ac\u00022\b\u0010\u00f2\u0002\u001a\u00030\u0090\u0003H\u0002J\n\u0010\u0091\u0003\u001a\u00030\u00ac\u0002H\u0014J\u0014\u0010\u0092\u0003\u001a\u00030\u00ac\u00022\b\u0010\u0093\u0003\u001a\u00030\u00fb\u0002H\u0014J\u0013\u0010\u0094\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u008d\u0003\u001a\u00020\fH\u0016J\u0016\u0010\u0095\u0003\u001a\u00030\u00ac\u00022\n\u0010\u00eb\u0001\u001a\u0005\u0018\u00010\u00ec\u0001H\u0016J\n\u0010\u0096\u0003\u001a\u00030\u00ac\u0002H\u0014J\n\u0010\u0097\u0003\u001a\u00030\u00ac\u0002H\u0015J\n\u0010\u0098\u0003\u001a\u00030\u00ac\u0002H\u0016J1\u0010\u0099\u0003\u001a\u00030\u00ac\u00022\n\u0010\u00ad\u0002\u001a\u0005\u0018\u00010\u00b0\u00022\u0007\u0010\u00b1\u0002\u001a\u00020\f2\u0007\u0010\u009a\u0003\u001a\u00020\f2\u0007\u0010\u00b2\u0002\u001a\u00020\fH\u0016J\u0013\u0010\u009b\u0003\u001a\u00020\u00192\b\u0010\u00c3\u0002\u001a\u00030\u00c4\u0002H\u0016J\u0013\u0010\u009c\u0003\u001a\u00020\u00192\b\u0010\u00c3\u0002\u001a\u00030\u00c4\u0002H\u0016J\n\u0010\u009d\u0003\u001a\u00030\u00ac\u0002H\u0015J\n\u0010\u009e\u0003\u001a\u00030\u00ac\u0002H\u0016J\u0013\u0010\u009f\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00a0\u0003\u001a\u00020\u0019H\u0016J\n\u0010\u00a1\u0003\u001a\u00030\u00ac\u0002H\u0002J\b\u0010\u00a2\u0003\u001a\u00030\u00ac\u0002J\u001d\u0010\u00a3\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u008d\u0003\u001a\u00020\f2\b\u0010\u008e\u0003\u001a\u00030\u00c8\u0001H\u0016J\n\u0010\u00a4\u0003\u001a\u00030\u00ac\u0002H\u0016J\n\u0010\u00a5\u0003\u001a\u00030\u00ac\u0002H\u0016J\n\u0010\u00a6\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00a7\u0003\u001a\u00030\u00ac\u0002H\u0016J\u000f\u0010\u00a8\u0003\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0003\u0010\u00a9\u0003J\n\u0010\u00aa\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00ab\u0003\u001a\u00030\u00ac\u0002H\u0002J\u0013\u0010\u00ac\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00b6\u0002\u001a\u00020\fH\u0016J\u001c\u0010\u00ac\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u008d\u0003\u001a\u00020U2\t\b\u0002\u0010\u00ad\u0003\u001a\u00020\u0019J\'\u0010\u00ac\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u008d\u0003\u001a\u00020U2\t\b\u0002\u0010\u00ad\u0003\u001a\u00020\u00192\t\b\u0002\u0010\u00ae\u0003\u001a\u00020\u0019J8\u0010\u00ac\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u008d\u0003\u001a\u00020U2\u0007\u0010\u00af\u0003\u001a\u00020U2\t\b\u0002\u0010\u00ad\u0003\u001a\u00020\u00192\t\b\u0002\u0010\u00ae\u0003\u001a\u00020\u0019H\u0000\u00a2\u0006\u0003\b\u00b0\u0003J+\u0010\u00b1\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00b2\u0003\u001a\u00020\f2\u0007\u0010\u00b3\u0003\u001a\u00020\f2\u0007\u0010\u00b4\u0003\u001a\u00020\fH\u0000\u00a2\u0006\u0003\b\u00b5\u0003J\u0019\u0010\u00b6\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u009f\u0002\u001a\u00020\fH\u0000\u00a2\u0006\u0003\b\u00b7\u0003J\n\u0010\u00b8\u0003\u001a\u00030\u00ac\u0002H\u0002J\u0014\u0010\u00b9\u0003\u001a\u00030\u00ac\u00022\b\u0010\u00ba\u0003\u001a\u00030\u00bb\u0003H\u0016J\n\u0010\u00bc\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00bd\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00be\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00bf\u0003\u001a\u00030\u00ac\u0002H\u0002J\u0013\u0010\u00c0\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00c1\u0003\u001a\u00020\u0019H\u0002J\u0013\u0010\u00c2\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00c3\u0003\u001a\u00020\fH\u0002J\u0013\u0010\u00c4\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00c5\u0003\u001a\u00020WH\u0002J\n\u0010\u00c6\u0003\u001a\u00030\u00ac\u0002H\u0016J\u0013\u0010\u00c7\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00c8\u0003\u001a\u000203H\u0002J\u0014\u0010\u00c9\u0003\u001a\u00030\u00ac\u00022\b\u0010\u00ca\u0003\u001a\u00030\u00cb\u0003H\u0002J\n\u0010\u00cc\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00cd\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00ce\u0003\u001a\u00030\u00ac\u0002H\u0016J\u0011\u0010\u00cf\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00c8\u0003\u001a\u000203J\n\u0010\u00d0\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00d1\u0003\u001a\u00030\u00ac\u0002H\u0002J\u0013\u0010\u00d2\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00d3\u0003\u001a\u00020\u0019H\u0002J\n\u0010\u00d4\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00d5\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00d6\u0003\u001a\u00030\u00ac\u0002H\u0003J\n\u0010\u00d7\u0003\u001a\u00030\u00ac\u0002H\u0016J\n\u0010\u00d8\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00d9\u0003\u001a\u00030\u00ac\u0002H\u0002J\u0011\u0010\u00da\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00db\u0003\u001a\u00020\u0019J\n\u0010\u0082\u0002\u001a\u00030\u00ac\u0002H\u0007J\b\u0010\u00dc\u0003\u001a\u00030\u00ac\u0002J\u0013\u0010\u00dd\u0003\u001a\u00030\u00ac\u00022\u0007\u0010\u00de\u0003\u001a\u00020\u0019H\u0002J\b\u0010\u00df\u0003\u001a\u00030\u00ac\u0002J\b\u0010\u00e0\u0003\u001a\u00030\u00ac\u0002J\n\u0010\u00e1\u0003\u001a\u00030\u00ac\u0002H\u0016J\b\u0010\u00e2\u0003\u001a\u00030\u00ac\u0002J\n\u0010\u00e3\u0003\u001a\u00030\u00ac\u0002H\u0016J\n\u0010\u00e4\u0003\u001a\u00030\u00ac\u0002H\u0002J\b\u0010\u00e5\u0003\u001a\u00030\u00ac\u0002J)\u0010\u00e6\u0003\u001a\u00020\u00192\u0007\u0010\u00e7\u0003\u001a\u00020W2\u0007\u0010\u00e8\u0003\u001a\u00020W2\u0006\u0010V\u001a\u00020WH\u0000\u00a2\u0006\u0003\b\u00e9\u0003J\n\u0010\u00ea\u0003\u001a\u00030\u00ac\u0002H\u0002J\n\u0010\u00eb\u0003\u001a\u00030\u00ac\u0002H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020$@BX\u0080.\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u00104\u001a\u0002058F\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u00109\u001a\u0016\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;\u0018\u00010:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u000e\u0010C\u001a\u00020DX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020FX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0;\u0018\u00010LX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0;0NX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020WX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0011\u0010\\\u001a\u00020]\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010Q\"\u0004\bb\u0010SR\u001e\u0010c\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010QR\u001a\u0010e\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010Q\"\u0004\bf\u0010SR\u000e\u0010g\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010h\u001a\u00020\u00198CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010QR\u001e\u0010i\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010QR\u001a\u0010k\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010Q\"\u0004\bl\u0010SR\u000e\u0010m\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010n\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010Q\"\u0004\bo\u0010SR\u0014\u0010p\u001a\u00020\u00198@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bq\u0010QR\u0014\u0010r\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\br\u0010QR\u0014\u0010s\u001a\u00020\u00198@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bt\u0010QR\u000e\u0010u\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010v\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\bv\u0010QR\u001a\u0010w\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010Q\"\u0004\bx\u0010SR\u001a\u0010y\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010Q\"\u0004\bz\u0010SR\u001a\u0010{\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010Q\"\u0004\b|\u0010SR\u000e\u0010}\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0082\u0001\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010Q\"\u0005\b\u0084\u0001\u0010SR\u000f\u0010\u0085\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0087\u0001\u001a\u00020]8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020WX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u00a0\u0001\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u00a1\u0001\u001a\u00030\u00a2\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u001e\u0010\u00a7\u0001\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u0011\n\u0000\u001a\u0005\b\u00a8\u0001\u0010#\"\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0012\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00ac\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u00ad\u0001\u001a\u00030\u00ae\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001\"\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u001d\u0010\u00b3\u0001\u001a\u00020WX\u0080\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b4\u0001\u0010Y\"\u0005\b\u00b5\u0001\u0010[R \u0010\u00b6\u0001\u001a\u00030\u00b7\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ba\u0001\u0010B\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u000f\u0010\u00bb\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u00bc\u0001\u001a\u00030\u00bd\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00c0\u0001\u0010B\u001a\u0006\b\u00be\u0001\u0010\u00bf\u0001R\"\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00c2\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001\"\u0006\b\u00c5\u0001\u0010\u00c6\u0001R!\u0010\u00c7\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00c8\u00010;0N\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u0011\u0010\u00cb\u0001\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u00cc\u0001\u001a\u00030\u00cd\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00d0\u0001\u0010B\u001a\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\"\u0010\u00d1\u0001\u001a\u0005\u0018\u00010\u00d2\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\"\u0006\b\u00d5\u0001\u0010\u00d6\u0001R\u001e\u0010\u00d7\u0001\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u0011\n\u0000\u001a\u0005\b\u00d8\u0001\u0010#\"\u0006\b\u00d9\u0001\u0010\u00aa\u0001R(\u0010\u00da\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00c8\u0001\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001\"\u0006\b\u00dd\u0001\u0010\u00de\u0001R\u000f\u0010\u00df\u0001\u001a\u00020UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u00e0\u0001\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00e1\u0001\u0010#R \u0010\u00e2\u0001\u001a\u00030\u00e3\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00e6\u0001\u0010B\u001a\u0006\b\u00e4\u0001\u0010\u00e5\u0001R\u0015\u0010\u00e7\u0001\u001a\u00030\u00e8\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00e9\u0001\u0010\u00ea\u0001R\"\u0010\u00eb\u0001\u001a\u0005\u0018\u00010\u00ec\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00ed\u0001\u0010\u00ee\u0001\"\u0006\b\u00ef\u0001\u0010\u00f0\u0001R\u000f\u0010\u00f1\u0001\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u00f2\u0001\u001a\u00030\u00f3\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00f4\u0001\u0010\u00f5\u0001\"\u0006\b\u00f6\u0001\u0010\u00f7\u0001R\u0010\u0010\u00f8\u0001\u001a\u00030\u00f9\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u00fa\u0001\u001a\u00030\u00fb\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00fe\u0001\u0010B\u001a\u0006\b\u00fc\u0001\u0010\u00fd\u0001R\u0011\u0010\u00ff\u0001\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0002\u001a\u00030\u0081\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0002\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0002\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0084\u0002\u001a\u00020U8F\u00a2\u0006\b\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002R \u0010\u0087\u0002\u001a\u00030\u0088\u00028FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008b\u0002\u0010B\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R \u0010\u008c\u0002\u001a\u00030\u008d\u0002X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002\"\u0006\b\u0090\u0002\u0010\u0091\u0002R\"\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0093\u0002X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u0097\u0002R\"\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u0002X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R\u000f\u0010\u009e\u0002\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u009f\u0002\u001a\u00020WX\u0080\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a0\u0002\u0010Y\"\u0005\b\u00a1\u0002\u0010[R\u0012\u0010\u00a2\u0002\u001a\u0005\u0018\u00010\u00a3\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a4\u0002\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u00a5\u0002\u001a\u00030\u00a6\u0002X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a7\u0002\u0010\u00a8\u0002\"\u0006\b\u00a9\u0002\u0010\u00aa\u0002\u00a8\u0006\u00ed\u0003"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoPlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lorg/videolan/vlc/PlaybackService$Callback;", "Lorg/videolan/vlc/gui/audio/PlaylistAdapter$IPlayer;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lorg/videolan/vlc/gui/helpers/hf/StoragePermissionsDelegate$CustomActionController;", "Landroid/text/TextWatcher;", "Lorg/videolan/vlc/util/IDialogManager;", "Lorg/videolan/vlc/gui/helpers/KeycodeListener;", "()V", "IDEX_FIRST_MUTE", "", "IDEX_MAIN_LIST", "IDEX_SHOW_CHANGE_SPEED_MSG", "IDEX_SHOW_MSG", "IDEX_SHOW_PLAY_TIME_MSG", "IDEX_SHOW_TIME_SELECT", "TIME_FIRST_MUTE", "TIME_MAIN_LIST", "TIME_SHOW_CHANGE_SPEED_MSG", "TIME_SHOW_MSG", "TIME_SHOW_PLAY_TIME_MSG", "TIME_SHOW_TIME_SELECT", "addNextTrack", "", "addedExternalSubs", "Ljava/util/ArrayList;", "Lorg/videolan/vlc/mediadb/models/ExternalSub;", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "askResume", "<set-?>", "audioMax", "getAudioMax$vlc_android_debug", "()I", "Landroid/media/AudioManager;", "audiomanager", "getAudiomanager$vlc_android_debug", "()Landroid/media/AudioManager;", "baseContextWrappingDelegate", "Landroidx/appcompat/app/AppCompatDelegate;", "bookmarkModel", "Lorg/videolan/vlc/viewmodels/BookmarkModel;", "getBookmarkModel", "()Lorg/videolan/vlc/viewmodels/BookmarkModel;", "setBookmarkModel", "(Lorg/videolan/vlc/viewmodels/BookmarkModel;)V", "btReceiver", "Landroid/content/BroadcastReceiver;", "currentAudioTrack", "", "currentScaleType", "Lorg/videolan/libvlc/MediaPlayer$ScaleType;", "getCurrentScaleType", "()Lorg/videolan/libvlc/MediaPlayer$ScaleType;", "currentSpuTrack", "currentTracks", "Lkotlin/Pair;", "", "Lorg/videolan/libvlc/interfaces/IMedia$Track;", "delayDelegate", "Lorg/videolan/vlc/gui/video/VideoDelayDelegate;", "getDelayDelegate", "()Lorg/videolan/vlc/gui/video/VideoDelayDelegate;", "delayDelegate$delegate", "Lkotlin/Lazy;", "dialogsDelegate", "Lorg/videolan/vlc/util/DialogDelegate;", "displayManager", "Lorg/videolan/libvlc/util/DisplayManager;", "getDisplayManager", "()Lorg/videolan/libvlc/util/DisplayManager;", "setDisplayManager", "(Lorg/videolan/libvlc/util/DisplayManager;)V", "downloadedSubtitleLiveData", "Landroidx/lifecycle/LiveData;", "downloadedSubtitleObserver", "Landroidx/lifecycle/Observer;", "enableCloneMode", "getEnableCloneMode", "()Z", "setEnableCloneMode", "(Z)V", "forcedTime", "", "fov", "", "getFov$vlc_android_debug", "()F", "setFov$vlc_android_debug", "(F)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "hasPhysicalNotch", "getHasPhysicalNotch", "setHasPhysicalNotch", "isAudioBoostEnabled", "isAudioBoostEnabled$vlc_android_debug", "isBenchmark", "setBenchmark", "isDragging", "isInteractive", "isLoading", "isLoading$vlc_android_debug", "isLocked", "setLocked", "isMute", "isNavMenu", "setNavMenu", "isOnPrimaryDisplay", "isOnPrimaryDisplay$vlc_android_debug", "isOptionsListShowing", "isPlaybackSettingActive", "isPlaybackSettingActive$vlc_android_debug", "isPlaying", "isPlaylistVisible", "isShowing", "setShowing", "isShowingDialog", "setShowingDialog", "isTv", "setTv", "lastAudioTrack", "lastSpuTrack", "lastTime", "loadingImageView", "Landroid/widget/ImageView;", "lockBackButton", "getLockBackButton", "setLockBackButton", "mCurrVol", "mErrCount", "mHandlerMsg", "mIdxPlayVideoFile", "mIsChangeSpeed", "mIsLastSetTime", "mIsListTouch", "mIsMainList", "mIsMute", "mIsRemoconControl", "mIsTimeSelect", "mLastSetTime", "mPlayRate", "mRemoconDvdMode", "mRemoconReceiver", "mRepeatMode", "mScaleType", "mStopCnt", "mStopMode", "mStorageMode", "mTimeSelHour1", "mTimeSelHour2", "mTimeSelMin1", "mTimeSelMin2", "mTimeSelMode", "mTimeSelSec1", "mTimeSelSec2", "mVolumeReceiver", "medialibrary", "Lorg/videolan/medialibrary/interfaces/Medialibrary;", "getMedialibrary", "()Lorg/videolan/medialibrary/interfaces/Medialibrary;", "setMedialibrary", "(Lorg/videolan/medialibrary/interfaces/Medialibrary;)V", "menuIdx", "getMenuIdx", "setMenuIdx", "(I)V", "optionsDelegate", "Lorg/videolan/vlc/gui/helpers/PlayerOptionsDelegate;", "orientationMode", "Lorg/videolan/vlc/gui/video/PlayerOrientationMode;", "getOrientationMode", "()Lorg/videolan/vlc/gui/video/PlayerOrientationMode;", "setOrientationMode", "(Lorg/videolan/vlc/gui/video/PlayerOrientationMode;)V", "originalVol", "getOriginalVol$vlc_android_debug", "setOriginalVol$vlc_android_debug", "overlayDelegate", "Lorg/videolan/vlc/gui/video/VideoPlayerOverlayDelegate;", "getOverlayDelegate", "()Lorg/videolan/vlc/gui/video/VideoPlayerOverlayDelegate;", "overlayDelegate$delegate", "playbackStarted", "playerKeyListenerDelegate", "Lorg/videolan/vlc/gui/helpers/PlayerKeyListenerDelegate;", "getPlayerKeyListenerDelegate", "()Lorg/videolan/vlc/gui/helpers/PlayerKeyListenerDelegate;", "playerKeyListenerDelegate$delegate", "playlistModel", "Lorg/videolan/vlc/viewmodels/PlaylistModel;", "getPlaylistModel", "()Lorg/videolan/vlc/viewmodels/PlaylistModel;", "setPlaylistModel", "(Lorg/videolan/vlc/viewmodels/PlaylistModel;)V", "playlistObserver", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "getPlaylistObserver", "()Landroidx/lifecycle/Observer;", "previousMediaPath", "resizeDelegate", "Lorg/videolan/vlc/gui/video/VideoPlayerResizeDelegate;", "getResizeDelegate", "()Lorg/videolan/vlc/gui/video/VideoPlayerResizeDelegate;", "resizeDelegate$delegate", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "savedMediaIndex", "getSavedMediaIndex", "setSavedMediaIndex", "savedMediaList", "getSavedMediaList", "()Ljava/util/ArrayList;", "setSavedMediaList", "(Ljava/util/ArrayList;)V", "savedTime", "screenRotation", "getScreenRotation", "screenshotDelegate", "Lorg/videolan/vlc/gui/video/VideoPlayerScreenshotDelegate;", "getScreenshotDelegate", "()Lorg/videolan/vlc/gui/video/VideoPlayerScreenshotDelegate;", "screenshotDelegate$delegate", "seekListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "getSeekListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "service", "Lorg/videolan/vlc/PlaybackService;", "getService", "()Lorg/videolan/vlc/PlaybackService;", "setService", "(Lorg/videolan/vlc/PlaybackService;)V", "serviceReceiver", "settings", "Landroid/content/SharedPreferences;", "getSettings", "()Landroid/content/SharedPreferences;", "setSettings", "(Landroid/content/SharedPreferences;)V", "startedScope", "Lkotlinx/coroutines/CoroutineScope;", "statsDelegate", "Lorg/videolan/vlc/gui/video/VideoStatsDelegate;", "getStatsDelegate", "()Lorg/videolan/vlc/gui/video/VideoStatsDelegate;", "statsDelegate$delegate", "subtitlesExtraPath", "switchAudioRunnable", "Ljava/lang/Runnable;", "switchToPopup", "switchingView", "time", "getTime", "()J", "tipsDelegate", "Lorg/videolan/vlc/gui/video/VideoTipsDelegate;", "getTipsDelegate", "()Lorg/videolan/vlc/gui/video/VideoTipsDelegate;", "tipsDelegate$delegate", "touchDelegate", "Lorg/videolan/vlc/gui/video/VideoTouchDelegate;", "getTouchDelegate", "()Lorg/videolan/vlc/gui/video/VideoTouchDelegate;", "setTouchDelegate", "(Lorg/videolan/vlc/gui/video/VideoTouchDelegate;)V", "videoLayout", "Lorg/videolan/libvlc/util/VLCVideoLayout;", "getVideoLayout", "()Lorg/videolan/libvlc/util/VLCVideoLayout;", "setVideoLayout", "(Lorg/videolan/libvlc/util/VLCVideoLayout;)V", "videoUri", "Landroid/net/Uri;", "getVideoUri", "()Landroid/net/Uri;", "setVideoUri", "(Landroid/net/Uri;)V", "volSave", "volume", "getVolume$vlc_android_debug", "setVolume$vlc_android_debug", "warningToast", "Landroid/widget/Toast;", "wasPaused", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "getWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "setWindowLayoutInfo", "(Landroidx/window/layout/WindowLayoutInfo;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "bookmark", "changeBrightness", "delta", "changeBrightness$vlc_android_debug", "changeSpeed", "cleanUI", "createConfigurationContext", "Landroid/content/Context;", "overrideConfiguration", "Landroid/content/res/Configuration;", "decreaseRate", "dialogCanceled", "dialog", "Lorg/videolan/libvlc/Dialog;", "dispatchGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "displayResize", "displayWarningToast", "doPlayPause", "enableSubs", "encounteredError", "exit", "resultCode", "exitOK", "fireDialog", "generateTouchFlags", "getApplicationContext", "getCurrentMediaTracks", "getDelegate", "getOrientationForLock", "getScreenOrientation", "mode", "handleVout", "voutCount", "hide", "hideOptions", "hideSearchField", "increaseRate", "initAudioVolume", "initAudioVolume$vlc_android_debug", "()Lkotlin/Unit;", "initUI", "isInPictureInPictureMode", "isReady", "loadMedia", "fromStart", "forceUsingNew", "mute", "navigateDvdMenu", "keyCode", "navigateDvdMenu$vlc_android_debug", "next", "observeDownloadedSubtitles", "onActivityResult", "requestCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onAudioSubClick", "anchor", "onChangedControlSetting", "key", "onClick", "v", "onClickDismissTips", "onClickNextTips", "onConfigurationChanged", "newConfig", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "Landroid/view/KeyEvent;", "onLongClick", "onMediaEvent", "Lorg/videolan/libvlc/interfaces/IMedia$Event;", "onMediaPlayerEvent", "Lorg/videolan/libvlc/MediaPlayer$Event;", "onNewIntent", "intent", "onPause", "onPictureInPictureModeChanged", "onPlayNext", "onPlayPrev", "onPlaying", "onPopupMenu", "view", "position", "item", "onRemoconMode", "", "onResume", "onSaveInstanceState", "outState", "onSelectionSet", "onServiceChanged", "onStart", "onStop", "onStorageAccessGranted", "onTextChanged", "before", "onTouchEvent", "onTrackballEvent", "onUserLeaveHint", "onVisibleBehindCanceled", "onWindowFocusChanged", "hasFocus", "pause", "play", "playItem", "previous", "recreate", "removeDownloadedSubtitlesObserver", "resetRate", "resizeVideo", "()Ljava/lang/Boolean;", "restoreBrightness", "saveBrightness", "seek", "fromUser", "fast", "length", "seek$vlc_android_debug", "sendMouseEvent", "action", "x", "y", "sendMouseEvent$vlc_android_debug", "setAudioVolume", "setAudioVolume$vlc_android_debug", "setESTracks", "setPictureInPictureParams", "params", "Landroid/app/PictureInPictureParams;", "setPlayTime", "setPlaybackParameters", "setRepeatMode", "setSelTimeBg", "setSelTimeNum", "isUp", "setSelTimeNumKey", "num", "setWindowBrightness", "brightness", "showAdvancedOptions", "showChangeSpeedMsg", "msg", "showConfirmResumeDialog", "confirmation", "Lorg/videolan/vlc/media/WaitConfirmation;", "showCurrVol", "showCurrVolOnly", "showEqualizer", "showMsg", "showMute", "showNavMenu", "showTimeSelect", "isShow", "showTitle", "startLoading", "startPlayback", "stop", "stopLoading", "stopPlayback", "switchToAudioMode", "showUI", "takeScreenshot", "toggleBtDelay", "connected", "toggleLock", "toggleOrientation", "togglePlayPause", "toggleTimeDisplay", "update", "updateMute", "updateNavStatus", "updateViewpoint", "yaw", "pitch", "updateViewpoint$vlc_android_debug", "volumeDown", "volumeUp", "Companion", "vlc-android_debug"})
public class VideoPlayerActivity extends androidx.appcompat.app.AppCompatActivity implements org.videolan.vlc.PlaybackService.Callback, org.videolan.vlc.gui.audio.PlaylistAdapter.IPlayer, android.view.View.OnClickListener, android.view.View.OnLongClickListener, org.videolan.vlc.gui.helpers.hf.StoragePermissionsDelegate.CustomActionController, android.text.TextWatcher, org.videolan.vlc.util.IDialogManager, org.videolan.vlc.gui.helpers.KeycodeListener {
    private boolean hasPhysicalNotch = false;
    private java.lang.String subtitlesExtraPath;
    private kotlinx.coroutines.CoroutineScope startedScope;
    @org.jetbrains.annotations.Nullable()
    private org.videolan.vlc.PlaybackService service;
    public org.videolan.medialibrary.interfaces.Medialibrary medialibrary;
    @org.jetbrains.annotations.Nullable()
    private org.videolan.libvlc.util.VLCVideoLayout videoLayout;
    public org.videolan.libvlc.util.DisplayManager displayManager;
    @org.jetbrains.annotations.Nullable()
    private android.view.View rootView;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri videoUri;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<org.videolan.medialibrary.interfaces.media.MediaWrapper> savedMediaList;
    private int savedMediaIndex = 0;
    private boolean askResume = true;
    @org.jetbrains.annotations.Nullable()
    private org.videolan.vlc.viewmodels.PlaylistModel playlistModel;
    public android.content.SharedPreferences settings;
    private boolean isDragging = false;
    private boolean isShowing = false;
    private boolean isShowingDialog = false;
    private boolean isLoading = false;
    private boolean isPlaying = false;
    private android.widget.ImageView loadingImageView;
    private boolean enableCloneMode = false;
    public org.videolan.vlc.gui.video.PlayerOrientationMode orientationMode;
    private java.lang.String currentAudioTrack = "-2";
    private java.lang.String currentSpuTrack = "-2";
    private boolean isLocked = false;
    private java.lang.String lastAudioTrack = "-2";
    private java.lang.String lastSpuTrack = "-2";
    private boolean lockBackButton = false;
    private boolean wasPaused = false;
    private long savedTime = -1L;
    public androidx.window.layout.WindowLayoutInfo windowLayoutInfo;
    
    /**
     * For uninterrupted switching between audio and video mode
     */
    private boolean switchingView = false;
    private boolean switchToPopup = false;
    private android.media.AudioManager audiomanager;
    private int audioMax = 0;
    private boolean isAudioBoostEnabled = false;
    private boolean isMute = false;
    private int volSave = 0;
    private float volume = 0.0F;
    private float originalVol = 0.0F;
    private android.widget.Toast warningToast;
    private float fov = 0.0F;
    public org.videolan.vlc.gui.video.VideoTouchDelegate touchDelegate;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy statsDelegate$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy delayDelegate$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy screenshotDelegate$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy overlayDelegate$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy resizeDelegate$delegate = null;
    private final kotlin.Lazy playerKeyListenerDelegate$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy tipsDelegate$delegate = null;
    private boolean isTv = false;
    private final org.videolan.vlc.util.DialogDelegate dialogsDelegate = null;
    private androidx.appcompat.app.AppCompatDelegate baseContextWrappingDelegate;
    
    /**
     * Flag to indicate whether the media should be paused once loaded
     * (e.g. lock screen, or to restore the pause state)
     */
    private boolean playbackStarted = false;
    private int menuIdx = -1;
    private boolean isNavMenu = false;
    private long forcedTime = -1L;
    private long lastTime = -1L;
    private androidx.appcompat.app.AlertDialog alertDialog;
    private boolean isBenchmark = false;
    private final java.util.ArrayList<org.videolan.vlc.mediadb.models.ExternalSub> addedExternalSubs = null;
    private androidx.lifecycle.LiveData<java.util.List<org.videolan.vlc.mediadb.models.ExternalSub>> downloadedSubtitleLiveData;
    private java.lang.String previousMediaPath;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.Observer<java.util.List<org.videolan.medialibrary.interfaces.media.MediaWrapper>> playlistObserver = null;
    private boolean addNextTrack = false;
    
    /**
     * Handle resize of the surface and the overlay
     */
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private final java.lang.Runnable switchAudioRunnable = null;
    
    /**
     * handle changes of the seekbar (slicer)
     */
    @org.jetbrains.annotations.NotNull()
    private final android.widget.SeekBar.OnSeekBarChangeListener seekListener = null;
    private final androidx.lifecycle.Observer<java.util.List<org.videolan.vlc.mediadb.models.ExternalSub>> downloadedSubtitleObserver = null;
    private org.videolan.vlc.gui.helpers.PlayerOptionsDelegate optionsDelegate;
    public org.videolan.vlc.viewmodels.BookmarkModel bookmarkModel;
    private final android.content.BroadcastReceiver btReceiver = null;
    private final android.content.BroadcastReceiver serviceReceiver = null;
    private final int IDEX_SHOW_MSG = 1;
    private final int TIME_SHOW_MSG = 3000;
    private final int IDEX_SHOW_CHANGE_SPEED_MSG = 2;
    private final int TIME_SHOW_CHANGE_SPEED_MSG = 3000;
    private final int IDEX_SHOW_TIME_SELECT = 3;
    private final int TIME_SHOW_TIME_SELECT = 3000;
    private final int IDEX_SHOW_PLAY_TIME_MSG = 4;
    private final int TIME_SHOW_PLAY_TIME_MSG = 1000;
    private final int IDEX_FIRST_MUTE = 5;
    private final int TIME_FIRST_MUTE = 1000;
    private final int IDEX_MAIN_LIST = 6;
    private final int TIME_MAIN_LIST = 5000;
    private int mRepeatMode = org.videolan.vlc.common.MyConstants.REPEAT_FOLDER;
    private int mIdxPlayVideoFile = -1;
    private android.content.BroadcastReceiver mRemoconReceiver;
    private android.content.BroadcastReceiver mVolumeReceiver;
    private boolean mIsRemoconControl = false;
    private boolean mIsMute = false;
    private boolean mIsTimeSelect = false;
    private boolean mIsChangeSpeed = false;
    private boolean mIsLastSetTime = false;
    private boolean mIsMainList = false;
    private boolean mIsListTouch = false;
    private int mTimeSelHour1 = 0;
    private int mTimeSelHour2 = 0;
    private int mTimeSelMin1 = 0;
    private int mTimeSelMin2 = 0;
    private int mTimeSelSec1 = 0;
    private int mTimeSelSec2 = 0;
    private int mTimeSelMode = 0;
    private int mStorageMode = 0;
    private int mCurrVol = 0;
    private float mPlayRate = 1.0F;
    private long mLastSetTime = -1L;
    private int mStopMode = 0;
    private int mStopCnt = 0;
    private int mRemoconDvdMode = -1;
    private int mScaleType = 0;
    private int mErrCount = 0;
    private kotlin.Pair<java.lang.String, ? extends java.util.List<? extends org.videolan.libvlc.interfaces.IMedia.Track>> currentTracks;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.video.VideoPlayerActivity.Companion Companion = null;
    private static final java.lang.String TAG = "VLC/VideoPlayerActivity";
    private static final java.lang.String ACTION_RESULT = null;
    private static final java.lang.String EXTRA_POSITION = "extra_position";
    private static final java.lang.String EXTRA_DURATION = "extra_duration";
    private static final java.lang.String EXTRA_URI = "extra_uri";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FROM_EXTERNAL = "from_external";
    private static final int RESULT_CONNECTION_FAILED = 2;
    private static final int RESULT_PLAYBACK_ERROR = 3;
    private static final int RESULT_VIDEO_TRACK_LOST = 4;
    public static final float DEFAULT_FOV = 80.0F;
    private static final java.lang.String KEY_TIME = "saved_time";
    private static final java.lang.String KEY_LIST = "saved_list";
    private static final java.lang.String KEY_MEDIA_LIST = "media_list";
    private static final java.lang.String KEY_MEDIA_INDEX = "media_index";
    private static final java.lang.String KEY_URI = "saved_uri";
    public static final int OVERLAY_INFINITE = -1;
    public static final int FADE_OUT = 1;
    public static final int FADE_OUT_INFO = 2;
    private static final int START_PLAYBACK = 3;
    private static final int AUDIO_SERVICE_CONNECTION_FAILED = 4;
    private static final int RESET_BACK_LOCK = 5;
    private static final int CHECK_VIDEO_TRACKS = 6;
    private static final int LOADING_ANIMATION = 7;
    public static final int SHOW_INFO = 8;
    public static final int HIDE_INFO = 9;
    public static final int HIDE_SEEK = 10;
    public static final int HIDE_SETTINGS = 11;
    public static final int FADE_OUT_BRIGHTNESS_INFO = 12;
    public static final int FADE_OUT_VOLUME_INFO = 13;
    public static final int FADE_OUT_SCREENSHOT = 14;
    private static final java.lang.String KEY_REMAINING_TIME_DISPLAY = "remaining_time_display";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_BLUETOOTH_DELAY = "key_bluetooth_delay";
    private static final int LOADING_ANIMATION_DELAY = 1000;
    @kotlin.jvm.Volatile()
    private static volatile boolean sDisplayRemainingTime = false;
    private static java.lang.Boolean clone;
    @android.annotation.SuppressLint(value = {"HandlerLeak"})
    private final android.os.Handler mHandlerMsg = null;
    
    public VideoPlayerActivity() {
        super();
    }
    
    public final boolean getHasPhysicalNotch() {
        return false;
    }
    
    public final void setHasPhysicalNotch(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.vlc.PlaybackService getService() {
        return null;
    }
    
    public final void setService(@org.jetbrains.annotations.Nullable()
    org.videolan.vlc.PlaybackService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.medialibrary.interfaces.Medialibrary getMedialibrary() {
        return null;
    }
    
    public final void setMedialibrary(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.Medialibrary p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.libvlc.util.VLCVideoLayout getVideoLayout() {
        return null;
    }
    
    public final void setVideoLayout(@org.jetbrains.annotations.Nullable()
    org.videolan.libvlc.util.VLCVideoLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.libvlc.util.DisplayManager getDisplayManager() {
        return null;
    }
    
    public final void setDisplayManager(@org.jetbrains.annotations.NotNull()
    org.videolan.libvlc.util.DisplayManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getRootView() {
        return null;
    }
    
    public final void setRootView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getVideoUri() {
        return null;
    }
    
    public final void setVideoUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<org.videolan.medialibrary.interfaces.media.MediaWrapper> getSavedMediaList() {
        return null;
    }
    
    public final void setSavedMediaList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<org.videolan.medialibrary.interfaces.media.MediaWrapper> p0) {
    }
    
    public final int getSavedMediaIndex() {
        return 0;
    }
    
    public final void setSavedMediaIndex(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.vlc.viewmodels.PlaylistModel getPlaylistModel() {
        return null;
    }
    
    public final void setPlaylistModel(@org.jetbrains.annotations.Nullable()
    org.videolan.vlc.viewmodels.PlaylistModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSettings() {
        return null;
    }
    
    public final void setSettings(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    public final boolean isShowing() {
        return false;
    }
    
    public final void setShowing(boolean p0) {
    }
    
    public final boolean isShowingDialog() {
        return false;
    }
    
    public final void setShowingDialog(boolean p0) {
    }
    
    public final boolean isLoading$vlc_android_debug() {
        return false;
    }
    
    public final boolean getEnableCloneMode() {
        return false;
    }
    
    public final void setEnableCloneMode(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.PlayerOrientationMode getOrientationMode() {
        return null;
    }
    
    public final void setOrientationMode(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.video.PlayerOrientationMode p0) {
    }
    
    public final boolean isLocked() {
        return false;
    }
    
    public final void setLocked(boolean p0) {
    }
    
    public final boolean getLockBackButton() {
        return false;
    }
    
    public final void setLockBackButton(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.window.layout.WindowLayoutInfo getWindowLayoutInfo() {
        return null;
    }
    
    public final void setWindowLayoutInfo(@org.jetbrains.annotations.NotNull()
    androidx.window.layout.WindowLayoutInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.media.AudioManager getAudiomanager$vlc_android_debug() {
        return null;
    }
    
    public final int getAudioMax$vlc_android_debug() {
        return 0;
    }
    
    public final boolean isAudioBoostEnabled$vlc_android_debug() {
        return false;
    }
    
    public final float getVolume$vlc_android_debug() {
        return 0.0F;
    }
    
    public final void setVolume$vlc_android_debug(float p0) {
    }
    
    public final float getOriginalVol$vlc_android_debug() {
        return 0.0F;
    }
    
    public final void setOriginalVol$vlc_android_debug(float p0) {
    }
    
    public final float getFov$vlc_android_debug() {
        return 0.0F;
    }
    
    public final void setFov$vlc_android_debug(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoTouchDelegate getTouchDelegate() {
        return null;
    }
    
    public final void setTouchDelegate(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.video.VideoTouchDelegate p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoStatsDelegate getStatsDelegate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoDelayDelegate getDelayDelegate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoPlayerScreenshotDelegate getScreenshotDelegate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoPlayerOverlayDelegate getOverlayDelegate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoPlayerResizeDelegate getResizeDelegate() {
        return null;
    }
    
    private final org.videolan.vlc.gui.helpers.PlayerKeyListenerDelegate getPlayerKeyListenerDelegate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.video.VideoTipsDelegate getTipsDelegate() {
        return null;
    }
    
    public final boolean isTv() {
        return false;
    }
    
    public final void setTv(boolean p0) {
    }
    
    public final int getMenuIdx() {
        return 0;
    }
    
    public final void setMenuIdx(int p0) {
    }
    
    public final boolean isNavMenu() {
        return false;
    }
    
    public final void setNavMenu(boolean p0) {
    }
    
    public final boolean isBenchmark() {
        return false;
    }
    
    public final void setBenchmark(boolean p0) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.KITKAT_WATCH)
    private final boolean isInteractive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.Observer<java.util.List<org.videolan.medialibrary.interfaces.media.MediaWrapper>> getPlaylistObserver() {
        return null;
    }
    
    public final boolean isPlaybackSettingActive$vlc_android_debug() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.SeekBar.OnSeekBarChangeListener getSeekListener() {
        return null;
    }
    
    public final boolean isOnPrimaryDisplay$vlc_android_debug() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.libvlc.MediaPlayer.ScaleType getCurrentScaleType() {
        return null;
    }
    
    private final boolean isOptionsListShowing() {
        return false;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    private final int getScreenRotation() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.viewmodels.BookmarkModel getBookmarkModel() {
        return null;
    }
    
    public final void setBookmarkModel(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.viewmodels.BookmarkModel p0) {
    }
    
    public final boolean isPlaylistVisible() {
        return false;
    }
    
    private final void hide() {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.content.Context getApplicationContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.appcompat.app.AppCompatDelegate getDelegate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.content.Context createConfigurationContext(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration overrideConfiguration) {
        return null;
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onAttachedToWindow() {
    }
    
    /**
     * Generates the touch flags for the [overlayDelegate] based on the controls settings
     *
     * @return the flag corresponding to the gesture the user wants to use
     */
    private final int generateTouchFlags() {
        return 0;
    }
    
    @java.lang.Override()
    public void fireDialog(@org.jetbrains.annotations.NotNull()
    org.videolan.libvlc.Dialog dialog) {
    }
    
    @java.lang.Override()
    public void dialogCanceled(@org.jetbrains.annotations.Nullable()
    org.videolan.libvlc.Dialog dialog) {
    }
    
    @java.lang.Override()
    public void afterTextChanged(@org.jetbrains.annotations.Nullable()
    android.text.Editable s) {
    }
    
    @java.lang.Override()
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence s, int start, int count, int after) {
    }
    
    @java.lang.Override()
    public void onTextChanged(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence s, int start, int before, int count) {
    }
    
    private final boolean hideSearchField() {
        return false;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    protected void onPause() {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    protected void onUserLeaveHint() {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    public final void switchToPopup() {
    }
    
    @java.lang.Override()
    public void onVisibleBehindCanceled() {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void saveBrightness() {
    }
    
    private final void restoreBrightness() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    private final void startPlayback() {
    }
    
    private final void initUI() {
    }
    
    private final void setPlaybackParameters() {
    }
    
    private final void stopPlayback() {
    }
    
    /**
     * Takes a screenshot from the surface view and forwards it to the [screenshotDelegate]
     */
    public final void takeScreenshot() {
    }
    
    private final void cleanUI() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public void exit(int resultCode) {
    }
    
    private final void exitOK() {
    }
    
    @java.lang.Override()
    public boolean onTrackballEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public boolean dispatchGenericMotionEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public void showEqualizer() {
    }
    
    @java.lang.Override()
    public void next() {
    }
    
    @java.lang.Override()
    public void previous() {
    }
    
    @java.lang.Override()
    public void stop() {
    }
    
    @java.lang.Override()
    public void seek(int delta) {
    }
    
    @java.lang.Override()
    public void togglePlayPause() {
    }
    
    @java.lang.Override()
    public void increaseRate() {
    }
    
    @java.lang.Override()
    public void decreaseRate() {
    }
    
    @java.lang.Override()
    public void resetRate() {
    }
    
    @java.lang.Override()
    public void bookmark() {
    }
    
    @java.lang.Override()
    public boolean isReady() {
        return false;
    }
    
    @java.lang.Override()
    public void showAdvancedOptions() {
    }
    
    private final void volumeUp() {
    }
    
    private final void volumeDown() {
    }
    
    public final boolean navigateDvdMenu$vlc_android_debug(int keyCode) {
        return false;
    }
    
    @java.lang.Override()
    public void update() {
    }
    
    @java.lang.Override()
    public void onMediaEvent(@org.jetbrains.annotations.NotNull()
    org.videolan.libvlc.interfaces.IMedia.Event event) {
    }
    
    @java.lang.Override()
    public void onMediaPlayerEvent(@org.jetbrains.annotations.NotNull()
    org.videolan.libvlc.MediaPlayer.Event event) {
    }
    
    /**
     * Extract all the tracks from the current media
     * The tracks are also cached in [currentTracks] to avoid some native calls
     *
     * @return a list of [IMedia.Track]
     */
    private final java.util.List<org.videolan.libvlc.interfaces.IMedia.Track> getCurrentMediaTracks() {
        return null;
    }
    
    private final void onPlaying() {
    }
    
    private final void encounteredError() {
    }
    
    private final void handleVout(int voutCount) {
    }
    
    @java.lang.Override()
    public void recreate() {
    }
    
    public final void switchToAudioMode(boolean showUI) {
    }
    
    @java.lang.Override()
    public boolean isInPictureInPictureMode() {
        return false;
    }
    
    @java.lang.Override()
    public void setPictureInPictureParams(@org.jetbrains.annotations.NotNull()
    android.app.PictureInPictureParams params) {
    }
    
    @java.lang.Override()
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
    }
    
    public final void sendMouseEvent$vlc_android_debug(int action, int x, int y) {
    }
    
    /**
     * show/hide the overlay
     */
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    public final boolean updateViewpoint$vlc_android_debug(float yaw, float pitch, float fov) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.Unit initAudioVolume$vlc_android_debug() {
        return null;
    }
    
    public final void displayWarningToast() {
    }
    
    public final void setAudioVolume$vlc_android_debug(int volume) {
    }
    
    private final void mute(boolean mute) {
    }
    
    private final void updateMute() {
    }
    
    public final void changeBrightness$vlc_android_debug(float delta) {
    }
    
    private final void setWindowBrightness(float brightness) {
    }
    
    public void onAudioSubClick(@org.jetbrains.annotations.Nullable()
    android.view.View anchor) {
    }
    
    @java.lang.Override()
    public void onPopupMenu(@org.jetbrains.annotations.NotNull()
    android.view.View view, int position, @org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.MediaWrapper item) {
    }
    
    @java.lang.Override()
    public void onSelectionSet(int position) {
    }
    
    @java.lang.Override()
    public void playItem(int position, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper item) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public boolean onLongClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
        return false;
    }
    
    public final void toggleTimeDisplay() {
    }
    
    public final void toggleLock() {
    }
    
    @java.lang.Override()
    public void onStorageAccessGranted() {
    }
    
    public final void hideOptions() {
    }
    
    private final void showNavMenu() {
    }
    
    public final void doPlayPause() {
    }
    
    public final void seek(long position, boolean fromUser) {
    }
    
    public final void seek(long position, boolean fromUser, boolean fast) {
    }
    
    public final void seek$vlc_android_debug(long position, long length, boolean fromUser, boolean fast) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean resizeVideo() {
        return null;
    }
    
    public final boolean displayResize() {
        return false;
    }
    
    private final void showTitle() {
    }
    
    private final void setESTracks() {
    }
    
    /**
     */
    public final void play() {
    }
    
    /**
     */
    private final void pause() {
    }
    
    /**
     * External extras:
     * - position (long) - position of the video to start with (in ms)
     * - subtitles_location (String) - location of a subtitles file to load
     * - from_start (boolean) - Whether playback should start from start or from resume point
     * - title (String) - video title, will be guessed from file if not set.
     */
    @android.annotation.TargetApi(value = 12)
    @android.annotation.SuppressLint(value = {"SdCardPath"})
    protected void loadMedia(boolean fromStart, boolean forceUsingNew) {
    }
    
    private final void enableSubs() {
    }
    
    private final void removeDownloadedSubtitlesObserver() {
    }
    
    private final void observeDownloadedSubtitles() {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.JELLY_BEAN_MR2)
    public final int getScreenOrientation(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.video.PlayerOrientationMode mode) {
        return 0;
    }
    
    private final int getOrientationForLock() {
        return 0;
    }
    
    private final void showConfirmResumeDialog(org.videolan.vlc.media.WaitConfirmation confirmation) {
    }
    
    public final void toggleOrientation() {
    }
    
    private final void toggleBtDelay(boolean connected) {
    }
    
    /**
     * Start the video loading animation.
     */
    private final void startLoading() {
    }
    
    /**
     * Stop the video loading animation.
     */
    private final void stopLoading() {
    }
    
    public final void onClickDismissTips(@org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    android.view.View v) {
    }
    
    public final void onClickNextTips(@org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    android.view.View v) {
    }
    
    public final void updateNavStatus() {
    }
    
    public void onServiceChanged(@org.jetbrains.annotations.Nullable()
    org.videolan.vlc.PlaybackService service) {
    }
    
    /**
     * Callback called when a Control setting has been changed in the advanced options
     */
    public final void onChangedControlSetting(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    private final void onRemoconMode(byte key) {
    }
    
    private final void setPlayTime() {
    }
    
    private final void setSelTimeNumKey(int num) {
    }
    
    private final void setSelTimeNum(boolean isUp) {
    }
    
    private final void setSelTimeBg() {
    }
    
    public final void showMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    private final void showChangeSpeedMsg(java.lang.String msg) {
    }
    
    private final void showTimeSelect(boolean isShow) {
    }
    
    private final void showMute() {
    }
    
    private final void showCurrVol() {
    }
    
    private final void showCurrVolOnly() {
    }
    
    private final void setRepeatMode() {
    }
    
    private final void onPlayNext() {
    }
    
    private final void onPlayPrev() {
    }
    
    private final void changeSpeed(float delta) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0006J8\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u00042\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0006J&\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0006J\u0016\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u001e\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00106\u001a\u00020(J\u001e\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J2\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0006H\u0002J\u001e\u0010=\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00107\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0012\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010)R\u001a\u0010*\u001a\u00020(X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006>"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoPlayerActivity$Companion;", "", "()V", "ACTION_RESULT", "", "AUDIO_SERVICE_CONNECTION_FAILED", "", "CHECK_VIDEO_TRACKS", "DEFAULT_FOV", "", "EXTRA_DURATION", "EXTRA_POSITION", "EXTRA_URI", "FADE_OUT", "FADE_OUT_BRIGHTNESS_INFO", "FADE_OUT_INFO", "FADE_OUT_SCREENSHOT", "FADE_OUT_VOLUME_INFO", "FROM_EXTERNAL", "HIDE_INFO", "HIDE_SEEK", "HIDE_SETTINGS", "KEY_BLUETOOTH_DELAY", "KEY_LIST", "KEY_MEDIA_INDEX", "KEY_MEDIA_LIST", "KEY_REMAINING_TIME_DISPLAY", "KEY_TIME", "KEY_URI", "LOADING_ANIMATION", "LOADING_ANIMATION_DELAY", "OVERLAY_INFINITE", "RESET_BACK_LOCK", "RESULT_CONNECTION_FAILED", "RESULT_PLAYBACK_ERROR", "RESULT_VIDEO_TRACK_LOST", "SHOW_INFO", "START_PLAYBACK", "TAG", "clone", "", "Ljava/lang/Boolean;", "sDisplayRemainingTime", "getSDisplayRemainingTime$vlc_android_debug", "()Z", "setSDisplayRemainingTime$vlc_android_debug", "(Z)V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "title", "fromStart", "openedPosition", "action", "mw", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "start", "", "startOpened", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getSDisplayRemainingTime$vlc_android_debug() {
            return false;
        }
        
        public final void setSDisplayRemainingTime$vlc_android_debug(boolean p0) {
        }
        
        public final void start(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri) {
        }
        
        public final void start(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri, boolean fromStart) {
        }
        
        public final void start(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
        }
        
        public final void startOpened(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri, int openedPosition) {
        }
        
        private final void start(android.content.Context context, android.net.Uri uri, java.lang.String title, boolean fromStart, int openedPosition) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent getIntent(@org.jetbrains.annotations.NotNull()
        java.lang.String action, @org.jetbrains.annotations.NotNull()
        org.videolan.medialibrary.interfaces.media.MediaWrapper mw, boolean fromStart, int openedPosition) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent getIntent(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.Nullable()
        java.lang.String title, boolean fromStart, int openedPosition) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent getIntent(@org.jetbrains.annotations.NotNull()
        java.lang.String action, @org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.Nullable()
        java.lang.String title, boolean fromStart, int openedPosition) {
            return null;
        }
    }
}